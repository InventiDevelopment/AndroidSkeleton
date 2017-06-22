package cz.inventi.inventiskeleton.domain.post

import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.domain.common.BaseObservableUseCase
import cz.inventi.inventiskeleton.domain.common.ObservableUseCase
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by tomas.valenta on 5/11/2017.
 */

class GetPostListUseCase
    @Inject constructor(base: BaseObservableUseCase<List<Post>, GetPostListUseCase.Params>, val repository: PostRepository)
    : ObservableUseCase<List<Post>, GetPostListUseCase.Params> by base {

    override fun buildUseCaseObservable(params: Params): Observable<List<Post>> {
        return repository.postList().map { it.take(params.limit) }
    }

    data class Params(val limit: Int = 100)
}