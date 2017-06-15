package cz.inventi.inventiskeleton.presentation.post.list.mvi

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.jakewharton.rxbinding2.view.clicks
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.presentation.common.MviBaseController
import cz.inventi.inventiskeleton.presentation.common.bindView
import cz.inventi.inventiskeleton.presentation.post.list.MviPostListView
import io.reactivex.Observable
import javax.inject.Inject


class MviPostListController : MviBaseController<MviPostListView, MviPostListPresenter>(), MviPostListView {


    internal val reloadBtn: Button by bindView(R.id.reload_btn)
    internal val listView: RecyclerView by bindView(R.id.list_view)

    @Inject lateinit var postListPresenter: MviPostListPresenter

    override fun getLayoutResId() = R.layout.controller_list

    override fun createPresenter() = postListPresenter

    override fun onViewBind(view: View) {
        super.onViewBind(view)
    }

    override fun render(viewState: MviPostListPresenter.PostListViewState) {

    }

    override fun showPostList(posts: List<Post>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getReloadIntent(): Observable<Unit> = reloadBtn.clicks()

}
