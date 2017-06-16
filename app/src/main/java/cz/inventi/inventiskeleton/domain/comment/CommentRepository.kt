package cz.inventi.inventiskeleton.domain.comment

import cz.inventi.inventiskeleton.data.comment.Comment
import io.reactivex.Flowable

/**
 * Created by ecnill on 14-Jun-17.
 */

interface CommentRepository {
    fun commentList(postId: Double): Flowable<List<Comment>>
}