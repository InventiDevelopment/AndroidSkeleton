package cz.inventi.inventiskeleton.presentation.post;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cz.inventi.inventiskeleton.R;
import cz.inventi.inventiskeleton.presentation.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by tomas.valenta on 6/14/2017.
 */

@RunWith(AndroidJUnit4.class)
public class PostListScreenTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickAddPostButton_opensAddPostUi() throws Exception {
        // Click on the add note button
        onView(withId(R.id.add_post)).perform(click());

        // Check if the add note screen is displayed
        onView(withId(R.id.post_title_edit)).check(matches(isDisplayed()));
    }
}
