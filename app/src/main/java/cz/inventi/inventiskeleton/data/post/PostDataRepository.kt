package cz.inventi.inventiskeleton.data.post

import com.google.firebase.database.FirebaseDatabase
import cz.inventi.inventiskeleton.domain.post.PostRepository
import durdinapps.rxfirebase2.DataSnapshotMapper
import durdinapps.rxfirebase2.RxFirebaseDatabase
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject


/**
 * Created by tomas.valenta on 5/25/2017.
 */
class PostDataRepository @Inject constructor(val dbStorage: FirebaseDatabase) : PostRepository {
    override fun savePost(title: String, body: String): Observable<Post> {
        return Observable.just(Post(489, 489, title, body))
    }

    override fun post(postId: Double): Flowable<Post> {
        val postRef = dbStorage.reference.child("posts").orderByChild("id").equalTo(postId)
        return RxFirebaseDatabase.observeValueEvent(postRef, Post::class.java)
    }

    override fun postList(): Flowable<List<Post>> {
        return RxFirebaseDatabase.observeValueEvent(dbStorage.reference.child("posts"), DataSnapshotMapper.listOf(Post::class.java))
    }
}