package cz.inventi.inventiskeleton.presentation.post.list

import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.presentation.common.MviBaseView
import cz.inventi.inventiskeleton.presentation.post.list.mvi.MviPostListPresenter
import io.reactivex.Observable

/**
 * Created by semanticer on 05.05.2017.
 */

interface MviPostListView : MviBaseView<MviPostListPresenter.PostListViewState> {
    fun showPostList(posts: List<Post>)
    fun getReloadIntent(): Observable<Unit>
}
