package cz.inventi.inventiskeleton.data.common.remote

import cz.inventi.inventiskeleton.data.post.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by tomas.valenta on 5/16/2017.
 */

interface RemotePlaceholderService {
    @GET("posts")
    fun postList(): Observable<List<Post>>

    @GET("post/{id}")
    fun post(postId: Int): Observable<Post>
}
