package cz.inventi.inventiskeleton.data.comment

import com.google.firebase.database.FirebaseDatabase
import cz.inventi.inventiskeleton.domain.comment.CommentRepository
import durdinapps.rxfirebase2.DataSnapshotMapper
import durdinapps.rxfirebase2.RxFirebaseDatabase
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by ecnill on 14-Jun-17.
 */

class CommentDataRepository @Inject constructor(val dbStorage: FirebaseDatabase) : CommentRepository {

    override fun commentList(postId: Double): Flowable<List<Comment>> {
        return RxFirebaseDatabase.observeValueEvent(dbStorage.reference.child("comments").orderByChild("postId").equalTo(postId), DataSnapshotMapper.listOf(Comment::class.java))
    }

}
