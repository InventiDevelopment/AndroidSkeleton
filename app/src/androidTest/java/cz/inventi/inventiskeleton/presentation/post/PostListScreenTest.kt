package cz.inventi.inventiskeleton.presentation.post

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.presentation.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by tomas.valenta on 6/14/2017.
 */

@RunWith(AndroidJUnit4::class)
class PostListScreenTest {

    @Rule
    @JvmField
    val mainActivity = ActivityTestRule(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun clickAddPostButton_opensAddPostUi() {
        // Click on the add post button
        onView(withId(R.id.add_post)).perform(click())

        // Check if the add post screen is displayed
        onView(withId(R.id.post_title_edit)).check(matches(isDisplayed()))
    }
}
