package cz.inventi.inventiskeleton.presentation.post.add


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.di.conductorlib.ConductorInjection
import cz.inventi.inventiskeleton.presentation.common.BaseMviController
import cz.inventi.inventiskeleton.presentation.common.bindView
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by tomas.valenta on 6/7/2017.
 */

class PostAddController  : BaseMviController<PostAddView, PostAddPresenter>(), PostAddView {


    @Inject lateinit var postAddPresenter: PostAddPresenter

    internal val titleEdit: EditText by bindView(R.id.post_title_edit)
    internal val bodyEdit: EditText by bindView(R.id.post_body_edit)
    internal val doneBtn: Button by bindView(R.id.done_btn)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        ConductorInjection.inject(this)
        return super.onCreateView(inflater, container)
    }

    override fun onViewBind(view: View) {
        RxView.clicks(doneBtn).subscribe({ _ -> postAddPresenter.onDoneClicked() })
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_post_add, container, false)
    }

    override fun createPresenter(): PostAddPresenter {
        return postAddPresenter
    }

    override fun titleEditEvents(): Observable<String> = observeEditTextChanges(titleEdit)

    override fun bodyEditEvents(): Observable<String> = observeEditTextChanges(bodyEdit)

    private fun observeEditTextChanges(editText: EditText): Observable<String> {
        return RxTextView.textChanges(editText).skipInitialValue().map { e -> e.toString() }
    }

    override fun render(viewState: String) =  bodyEdit.setText(viewState)

}

