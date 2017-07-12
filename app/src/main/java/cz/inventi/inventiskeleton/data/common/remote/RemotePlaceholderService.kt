package cz.inventi.inventiskeleton.data.common.remote

import cz.inventi.inventiskeleton.data.comment.Comment
import cz.inventi.inventiskeleton.data.post.Post
import io.reactivex.Maybe
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by tomas.valenta on 5/16/2017.
 */

interface RemotePlaceholderService {
    @GET("posts")
    fun postList(): Observable<List<Post>>

    @GET("posts/{id}")
    fun post(@Path("id") id: Int): Maybe<Post>

    @GET("posts/{id}/comments")
    fun commentList(@Path("id") id: Int): Observable<List<Comment>>

}
