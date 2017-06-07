package cz.inventi.inventiskeleton.presentation.post.add


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.di.conductorlib.ConductorInjection
import cz.inventi.inventiskeleton.presentation.common.BaseController
import javax.inject.Inject

/**
 * Created by tomas.valenta on 6/7/2017.
 */

class PostAddController  : BaseController<PostAddView, PostAddPresenter>(), PostAddView {

    @Inject lateinit var postAddPresenter: PostAddPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        ConductorInjection.inject(this)
        return super.onCreateView(inflater, container)
    }

    override fun onViewBind(view: View) {

    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_post_add, container, false)
    }

    override fun createPresenter(): PostAddPresenter {
        return postAddPresenter
    }


}

