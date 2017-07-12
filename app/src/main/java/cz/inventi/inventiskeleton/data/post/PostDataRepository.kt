package cz.inventi.inventiskeleton.data.post

import cz.inventi.inventiskeleton.data.common.remote.RemotePlaceholderService
import cz.inventi.inventiskeleton.domain.post.PostRepository
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by tomas.valenta on 5/25/2017.
 */
class PostDataRepository @Inject constructor(val remoteStore: RemotePlaceholderService, val localStore: LocalPostStore) : PostRepository {
    override fun savePost(title: String, body: String): Observable<Post> {
        return Observable.just(Post(489, 489, title, body))
    }

    override fun post(postId: Int): Observable<Post> {
        val remotePost = remoteStore.post(postId) // TODO update individual post in db
        val localPost = localStore.post(postId)
        return Maybe.merge(remotePost, localPost).toObservable() // TODO error handling an fix multiple return
    }

    override fun postList(): Observable<List<Post>> {
        val remotePostList = remoteStore.postList()
                .doOnNext { localStore.savePostList(it) }
//                .map { listOf(Post(1, 1, "From remote title", "From remote body")) + it } // for testing, add new remote element as first

        val localPostList = localStore.postList()
        // TODO this must be fixed, in ideal case we want fast result from local store and than any new result when data changes.
        // They may change right after remote service updates db. We also need to communicate somehow error messages from remote store
        return Observable.merge(localPostList, remotePostList)
    }
}
