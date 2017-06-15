package cz.inventi.inventiskeleton.presentation.post.add

import cz.inventi.inventiskeleton.presentation.common.BaseView
import io.reactivex.Observable

/**
 * Created by tomas.valenta on 6/7/2017.
 */
interface PostAddView : BaseView {
    fun titleEditEvents(): Observable<String>
    fun bodyEditEvents(): Observable<String>
    fun render(viewState: String)
}