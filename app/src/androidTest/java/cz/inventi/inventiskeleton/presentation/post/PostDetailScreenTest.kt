package cz.inventi.inventiskeleton.presentation.post

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.assertThat
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v4.content.ContextCompat
import android.view.View
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.presentation.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.v7.widget.RecyclerView
import android.widget.ImageView

import cz.inventi.inventiskeleton.presentation.post.list.PostListAdapter
import junit.framework.Assert.assertTrue
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matchers.equalTo

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

    @Test
    fun imageDownloaded() {
        val avatar = mainActivity.activity.findViewById<ImageView>(R.id.img_user_avatar)
        // if image is not downloaded, show default icon
        val errorIcon = ContextCompat.getDrawable(mainActivity.activity, R.mipmap.ic_launcher)
        assertThat(avatar.drawable.constantState, not(equalTo(errorIcon.constantState)))
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
