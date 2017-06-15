package cz.inventi.inventiskeleton.data.comment

import android.content.SharedPreferences
import com.f2prateek.rx.preferences2.RxSharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ecnill on 14-Jun-17.
 */

class LocalCommentStore @Inject constructor(val rxSharedPref: RxSharedPreferences, val sharedPreferences: SharedPreferences, val gson: Gson) {

    val COMMENTS_PREF = "comments"

    fun comment(commentId: Int): Observable<Comment> {
        return commentList().map { it.firstOrNull { it.id == commentId } }
    }

    fun commentList(): Observable<List<Comment>> {
        val listType = object : TypeToken<ArrayList<Comment>>() {}.type
        return rxSharedPref.getString(COMMENTS_PREF, "[]").asObservable().map { gson.fromJson<List<Comment>>(it, listType) }
    }

    fun saveCommentList(commentList: List<Comment>) {
        sharedPreferences.edit().putString(COMMENTS_PREF, gson.toJson(commentList)).apply()
    }

}
