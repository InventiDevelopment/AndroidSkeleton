package cz.inventi.inventiskeleton.presentation.post.list

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bluelinelabs.conductor.RouterTransaction
import com.jakewharton.rxbinding2.view.RxView
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.di.conductorlib.ConductorInjection
import cz.inventi.inventiskeleton.presentation.common.BaseController
import cz.inventi.inventiskeleton.presentation.common.bindView
import cz.inventi.inventiskeleton.presentation.post.add.PostAddController
import cz.inventi.inventiskeleton.presentation.post.detail.PostDetailController
import javax.inject.Inject

/**
 * Created by semanticer on 05.05.2017.
 */

class PostListController : BaseController<PostListView, PostListPresenter>(), PostListView {

    @Inject lateinit var postListPresenter: PostListPresenter
    val postListAdapter = PostListAdapter()

    internal val reloadBtn: Button by bindView(R.id.btn_reload)
    internal val listView: RecyclerView by bindView(R.id.list_view)
    internal val addPost: View by bindView(R.id.add_post)

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
        postListAdapter.onPostLongSelectedListener = {post -> presenter.onPostLongClicked(post)}

        // refactor someday
        RxView.clicks(addPost).subscribe({presenter.onAddPost()})
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_post_list, container, false)
    }

    override fun createPresenter() = postListPresenter

    override fun showPostList(posts: List<Post>) {
        postListAdapter.postList = posts as MutableList<Post>
    }

    override fun showDetailPost(id: Int) {
        router.pushController(RouterTransaction
                .with(PostDetailController.instance(id)).tag(PostDetailController.TAG))
    }

    override fun showAddPost() {
        router.pushController(RouterTransaction.with(PostAddController()))
    }

    override fun deletePost(post: Post) {
        // dummy demonstration of AutoUpdatableAdapter released by DiffUtil
        val copy: MutableList<Post> = mutableListOf()
        copy.addAll(postListAdapter.postList)
        copy.filter { it == post }.forEach { copy.remove(it) }

        postListAdapter.postList = copy
    }

}
