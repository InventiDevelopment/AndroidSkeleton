package cz.inventi.inventiskeleton.presentation.post.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.di.conductorlib.ConductorInjection
import cz.inventi.inventiskeleton.presentation.common.BaseController
import cz.inventi.inventiskeleton.presentation.common.bindView
import javax.inject.Inject



/**
 * Created by semanticer on 05.05.2017.
 */

class PostListController : BaseController<PostListView, PostListPresenter>(), PostListView {

    internal val testText: TextView by bindView(R.id.test_text)
    internal val reloadBtn: Button by bindView(R.id.reload_btn)

    @Inject lateinit var postListPresenter: PostListPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        ConductorInjection.inject(this)
        return super.onCreateView(inflater, container)
    }

    override fun onViewBind(view: View) {
        reloadBtn.setOnClickListener { presenter.reloadList() }
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_list, container, false)
    }

    override fun createPresenter(): PostListPresenter {
        return postListPresenter
    }

    override fun showText(text: String) {
        testText.text = text
    }

}
