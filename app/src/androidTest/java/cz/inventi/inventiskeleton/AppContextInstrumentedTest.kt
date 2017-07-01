package cz.inventi.inventiskeleton

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import cz.inventi.inventiskeleton.presentation.MainActivity
import junit.framework.Assert.assertTrue

/**
 * Created by ecnill on 01-Jul-17.
 */
@RunWith(AndroidJUnit4::class)
class AppContextInstrumentedTest {

    @Rule
    @JvmField
    val mainActivity = ActivityTestRule(MainActivity::class.java)

    private val packageName = "cz.inventi.inventiskeleton"

    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertTrue(appContext.packageName.contains(packageName))
    }

}