package cz.inventi.inventiskeleton.presentation.post.add

import android.util.Log
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import cz.inventi.inventiskeleton.data.common.remote.RemotePlaceholderService
import cz.inventi.inventiskeleton.data.post.Post
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by tomas.valenta on 6/7/2017.
 */
class PostAddPresenter @Inject constructor(val remoteStore: RemotePlaceholderService): MviBasePresenter<PostAddView, PostAddViewState>() {

    override fun bindIntents() {

        // Events => Actions
        val titleEdit: Observable<TitleChangeAction> = intent { view -> view.titleEditEvents().map { TitleChangeAction(it) } }.subscribeOn(Schedulers.newThread())
        val bodyEdit: Observable<BodyChangeAction> = intent { view -> view.bodyEditEvents().map { BodyChangeAction(it) } }.subscribeOn(Schedulers.newThread())
        val doneClicked: Observable<DoneClickedAction> = intent { view -> view.doneClickEvents().map { DoneClickedAction } }.subscribeOn(Schedulers.newThread())

        // TODO this part should be probably part of domain logic, also possible use of ObservableTransformers with compose operator
        // Actions => Partial State Changes
        val titleChange = titleEdit.map { TitleStateChange(it.text, if (it.text.length > 5) "" else "Title is too short") }
        val bodyChange = bodyEdit.map { BodyStateChange(it.text, if (it.text.length > 8) "" else "Body is too short") }
        val doneChange = doneClicked.flatMap { _ -> remoteStore.addPost("test", "blast", 1).toObservable().subscribeOn(Schedulers.newThread())}
                .doOnNext { newPost: Post ->  Log.d("PostAddPresenter", newPost.toString()); }
                .map { _ -> LoadingStateChange(false) }
                .startWith(LoadingStateChange(false))
                 // TODO after some time should return Loading false
        val allChanges = Observable.merge(titleChange, bodyChange, doneChange)
                .observeOn(AndroidSchedulers.mainThread())

        // Partial State Changes and Previous ViewState => New ViewState
        val initialState = PostAddViewState("", "", "", "", false)
        subscribeViewState(
                allChanges.scan(initialState, this::viewStateReducer).distinctUntilChanged(),
                { view, viewState -> view.render(viewState) }
        )
    }

    private fun viewStateReducer(previousState: PostAddViewState, partialStateChange: PartialStateChange) = when(partialStateChange) {
        is TitleStateChange -> previousState.copy(title = partialStateChange.title, titleError = partialStateChange.titleError)
        is BodyStateChange -> previousState.copy(body = partialStateChange.body, bodyError = partialStateChange.bodyError)
        is LoadingStateChange -> previousState.copy(isLoading = partialStateChange.isLoading)
    }
}

sealed class UiAction
data class TitleChangeAction(val text: String) : UiAction()
data class BodyChangeAction(val text: String) : UiAction()
object DoneClickedAction : UiAction()

sealed class PartialStateChange
data class TitleStateChange(val title: String, val titleError: String) : PartialStateChange()
data class BodyStateChange(val body: String, val bodyError: String) : PartialStateChange()
data class LoadingStateChange(val isLoading: Boolean) : PartialStateChange()

data class PostAddViewState(val title: String, val body: String, val titleError: String, val bodyError: String, val isLoading: Boolean)
