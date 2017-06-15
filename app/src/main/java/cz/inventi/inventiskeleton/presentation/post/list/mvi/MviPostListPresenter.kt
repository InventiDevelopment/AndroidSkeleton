package cz.inventi.inventiskeleton.presentation.post.list.mvi

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.domain.post.GetPostListUseCase
import cz.inventi.inventiskeleton.presentation.post.list.MviPostListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MviPostListPresenter(val getPostListUseCase: GetPostListUseCase) : MviBasePresenter<MviPostListView, MviPostListPresenter.PostListViewState>() {

    override fun bindIntents() {
        val intent = intent({ view ->
            view.getReloadIntent()
                    .flatMap {
                        getPostListUseCase.buildUseCaseObservable(GetPostListUseCase.Params(20))
                                .map { data -> PostListViewState(data = data) }
                                .startWith { PostListViewState(fetching = true) }
                                .subscribeOn(Schedulers.io())
                    }
        })

        val stateObservable = intent.observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(stateObservable, { view, viewState -> view.render(viewState) })
    }

    data class PostListViewState(val fetching: Boolean = false,
                                 val data: List<Post> = emptyList())
}
