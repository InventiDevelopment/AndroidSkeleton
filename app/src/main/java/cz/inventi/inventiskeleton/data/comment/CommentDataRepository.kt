package cz.inventi.inventiskeleton.data.comment

import cz.inventi.inventiskeleton.data.common.remote.RemotePlaceholderService
import cz.inventi.inventiskeleton.domain.comment.CommentRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ecnill on 14-Jun-17.
 */

class CommentDataRepository @Inject constructor(val remoteStore: RemotePlaceholderService, val localStore: LocalCommentStore) : CommentRepository {

    override fun commentList(postId: Int): Observable<List<Comment>> {
        val remoteCommentList = remoteStore.commentList(postId).doOnNext { localStore.saveCommentList(it) }
        val localCommentList = localStore.commentList()
        return Observable.merge(localCommentList, remoteCommentList)
    }

}
