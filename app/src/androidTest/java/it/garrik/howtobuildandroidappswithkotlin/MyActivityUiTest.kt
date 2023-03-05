package it.garrik.howtobuildandroidappswithkotlin

import android.content.Context
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityUiTest {
    @JvmField
    @Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    val context: Context = InstrumentationRegistry.getInstrumentation().getTargetContext()
    val sumText: String = context.resources.getString(R.string.the_sum_of_numbers_from_1_to_is, 5, "15")
    val invalidNumberError: String = context.resources.getString(R.string.error_invalid_number)

    @Test
    fun showSumResultInTextView() {
        activityRule.let { activity ->
            onView(withId(R.id.edit_text)).perform(replaceText("5"))
            onView(withId(R.id.button)).perform(click())
            onView(withId(R.id.text_view)).check(matches(withText(sumText)))
        }
    }

    @Test
    fun showErrorInTextView() {
        activityRule.let { activity ->
            onView(withId(R.id.edit_text)).perform(replaceText("-5"))
            onView(withId(R.id.button)).perform(click())
            onView(withId(R.id.text_view)).check(matches(withText(invalidNumberError)))
        }
    }
}