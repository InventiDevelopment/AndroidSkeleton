package cz.inventi.inventiskeleton.domain.post

import cz.inventi.inventiskeleton.data.post.Post
import io.reactivex.Observable

/**
 * Created by tomas.valenta on 5/25/2017.
 */
interface PostRepository {
    fun post(postId: Int): Observable<Post?>
    fun postList(): Observable<List<Post>>
}