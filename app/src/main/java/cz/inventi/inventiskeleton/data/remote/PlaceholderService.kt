package cz.inventi.inventiskeleton.data.remote

import cz.inventi.inventiskeleton.data.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by tomas.valenta on 5/16/2017.
 */

interface PlaceholderService {
    @GET("posts")
    fun postList(): Observable<List<Post>>
}
