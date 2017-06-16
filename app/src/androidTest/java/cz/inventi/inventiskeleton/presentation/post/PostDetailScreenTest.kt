package cz.inventi.inventiskeleton.presentation.post

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.presentation.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.v7.widget.RecyclerView

import cz.inventi.inventiskeleton.presentation.post.list.PostListAdapter
import junit.framework.Assert.assertTrue

/**
 * Created by ecnill on 16-Jun-17.
 */

@RunWith(AndroidJUnit4::class)
class PostDetailScreenTest {

    private val defaultCommentCount: Int = 3

    @Rule
    @JvmField
    val mainActivity = ActivityTestRule(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun clickShowMoreCommentsButton() {
        onView(withId(R.id.list_view)).perform(RecyclerViewActions
                .actionOnItemAtPosition<PostListAdapter.PostViewHolder>(0, click()))
        onView(withId(R.id.btn_show_comments)).perform(click())
        onView(withId(R.id.list_comments)).check(RecyclerViewItemCountAssertion(defaultCommentCount))
    }

    inner class RecyclerViewItemCountAssertion(private val expectedCount: Int) : ViewAssertion {
        override fun check(view: View, noViewFoundException: NoMatchingViewException?) = when (noViewFoundException) {
            null -> {
                val recyclerView = view as RecyclerView
                val adapter = recyclerView.adapter
                assertTrue(adapter.itemCount > expectedCount)
            } else -> throw noViewFoundException
        }
    }

}
