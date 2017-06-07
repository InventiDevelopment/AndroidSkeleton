package cz.inventi.inventiskeleton.data.post

import android.content.SharedPreferences
import com.f2prateek.rx.preferences2.RxSharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by tomas.valenta on 5/25/2017.
 */

class LocalPostStore @Inject constructor(val rxSharedPref: RxSharedPreferences, val sharedPreferences: SharedPreferences, val gson: Gson) {

    val POSTS_PREF = "posts"

    fun post(postId: Int): Observable<Post?> {
        return postList().map { it.firstOrNull { it.id == postId } }
    }

    fun postList(): Observable<List<Post>> {
        val listType = object : TypeToken<ArrayList<Post>>() {}.type
        return rxSharedPref.getString(POSTS_PREF, "[]").asObservable().map { gson.fromJson<List<Post>>(it, listType) }
    }

    fun savePostList(postList: List<Post>) {
        sharedPreferences.edit().putString(POSTS_PREF, gson.toJson(postList)).apply()
    }
}

