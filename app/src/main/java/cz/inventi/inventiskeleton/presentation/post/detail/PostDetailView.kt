package cz.inventi.inventiskeleton.presentation.post.detail

import cz.inventi.inventiskeleton.data.comment.Comment
import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.presentation.common.BaseView

/**
 * Created by ecnill on 6/7/2017.
 */

interface PostDetailView : BaseView {
    fun showDetailPost(post: Post)
    fun showComments(comments: List<Comment>)
    fun hideMoreCommentButton()
}