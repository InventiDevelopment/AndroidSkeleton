package cz.inventi.inventiskeleton

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.rule.UiThreadTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.ViewGroup
import android.view.ViewParent

import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction

import org.junit.Before
import org.junit.Rule
import org.junit.Test

import cz.inventi.inventiskeleton.presentation.MainActivity
import cz.inventi.inventiskeleton.presentation.post.detail.PostDetailController
import cz.inventi.inventiskeleton.presentation.post.list.PostListAdapter
import cz.inventi.inventiskeleton.presentation.post.list.PostListController

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNull.notNullValue
import org.junit.runner.RunWith

/**
 * Created by ecnill on 01-Jul-17.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @Rule
    @JvmField
    val mainActivity = ActivityTestRule(MainActivity::class.java)

    private val rootTag = "root"
    private val rootController = PostListController()
    private lateinit var router: Router
    private lateinit var viewGroup: ViewGroup

    @Before
    @Throws(Throwable::class)
    fun setup() {
        viewGroup = mainActivity.activity.findViewById<ViewGroup>(R.id.controller_container)
        UiThreadTestRule().runOnUiThread {
            router = Conductor.attachRouter(mainActivity.activity, viewGroup, null)
            router.setRoot(RouterTransaction.with(rootController).tag(rootTag))
        }
    }

    @Test
    @Throws(Throwable::class)
    fun ensureViewIsPresent() {
        assertThat<ViewParent>(viewGroup.parent, notNullValue())
        assertThat<ViewGroup>(viewGroup, notNullValue())
        assertThat<Router>(router, notNullValue())
    }

    @Test
    @Throws(Throwable::class)
    fun setRootController() {
        assertTrue(router.hasRootController())
        assertEquals(rootController, router.getControllerWithTag(rootTag))
    }

    @Test
    fun clickListItem_setNewController() {
        onView(ViewMatchers.withId(R.id.list_view)).perform(RecyclerViewActions
                .actionOnItemAtPosition<PostListAdapter.PostViewHolder>(0, ViewActions.click()))
        assertThat(router.getControllerWithTag(PostDetailController.TAG), notNullValue())
    }

}
