package cz.inventi.inventiskeleton.domain.post

import cz.inventi.inventiskeleton.data.post.Post
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by tomas.valenta on 5/25/2017.
 */
interface PostRepository {
    fun post(postId: Double): Flowable<Post>
    fun postList(): Flowable<List<Post>>
    fun savePost(title: String, body: String): Observable<Post>
}