package cz.inventi.inventiskeleton.data.common.remote

import cz.inventi.inventiskeleton.data.comment.Comment
import cz.inventi.inventiskeleton.data.post.Post
import io.reactivex.Maybe
import io.reactivex.Observable
import retrofit2.http.*

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

    @FormUrlEncoded
    @POST("posts")
    fun addPost(@Field("title") title: String, @Field("body") body: String, @Field("userId") userId: Int): Maybe<Post>

}
