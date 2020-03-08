package com.example.practicalwork8

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    var activityActivityTestRule: ActivityTestRule<MainActivity>  = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @Test
    fun convertButtonClick() {
        onView(withId(R.id.NumText)).perform(typeText("101"))
        onView(withId(R.id.convertButton)).perform(click());
        onView(withId(R.id.result2)).check(matches(withText("5.0")))
        onView(withId(R.id.result8)).check(matches(withText("65.0")))
        onView(withId(R.id.result16)).check(matches(withText("257.0")))
    }
}