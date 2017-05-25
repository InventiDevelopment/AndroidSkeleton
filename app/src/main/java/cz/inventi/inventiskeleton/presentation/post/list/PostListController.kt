package cz.inventi.inventiskeleton.presentation.post.list

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.di.conductorlib.ConductorInjection
import cz.inventi.inventiskeleton.presentation.common.BaseController
import cz.inventi.inventiskeleton.presentation.common.bindView
import javax.inject.Inject


/**
 * Created by semanticer on 05.05.2017.
 */

class PostListController : BaseController<PostListView, PostListPresenter>(), PostListView {

    internal val reloadBtn: Button by bindView(R.id.reload_btn)
    internal val listView: RecyclerView by bindView(R.id.list_view)

    @Inject lateinit var postListPresenter: PostListPresenter

    val postListAdapter = PostListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        ConductorInjection.inject(this)
        return super.onCreateView(inflater, container)
    }

    override fun onViewBind(view: View) {
        reloadBtn.setOnClickListener { presenter.reloadList() }

        listView.setHasFixedSize(true)
        listView.layoutManager = LinearLayoutManager(activity)
        listView.adapter = postListAdapter
        postListAdapter.onPostSelectedListener = {post ->  presenter.onPostSelected(post)}
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_list, container, false)
    }

    override fun createPresenter(): PostListPresenter {
        return postListPresenter
    }

    override fun showPostList(posts: List<Post>) {
        postListAdapter.updateData(posts)
    }

}
