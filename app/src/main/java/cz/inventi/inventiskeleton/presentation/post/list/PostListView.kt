package cz.inventi.inventiskeleton.presentation.post.list

import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.presentation.common.BaseView

/**
 * Created by semanticer on 05.05.2017.
 */

interface PostListView : BaseView {
    fun showPostList(posts: List<Post>)
    fun showAddPost()
    fun showDetailPost(id : Int)
    fun deletePost(post: Post)
}
