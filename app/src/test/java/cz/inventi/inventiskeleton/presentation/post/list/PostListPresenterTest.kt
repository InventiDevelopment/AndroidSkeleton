package cz.inventi.inventiskeleton.presentation.post.list

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.domain.post.GetPostListUseCase
import org.junit.Before
import org.junit.Test

/**
 * Created by tomas.valenta on 6/13/2017.
 */
class PostListPresenterTest {

    private lateinit var presenter: PostListPresenter

    private val getListUseCase: GetPostListUseCase = mock()
    private val view: PostListView = mock()

    private val POST: Post = Post(5, 50, "Title", "Body")

    @Before
    fun setupPostListPresenter() {
        presenter = PostListPresenter(getListUseCase)
        presenter.attachView(view)
    }

    @Test
    fun attachView() {
//        presenter.attachView(view) is called during setup
        verify(getListUseCase).execute(any(), any())
    }

    @Test
    fun detachView() {
        presenter.detachView(false)
        verify(getListUseCase).dispose()
    }

    @Test
    fun onPostSelected() {
        presenter.onPostSelected(POST)
        verify(view).showDetailPost(POST.id)
    }

    @Test
    fun onAddPost() {
        presenter.onAddPost()
        verify(view).showAddPost()
    }


}