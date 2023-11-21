package com.example.practical_work_10

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class ComposeUiTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun composeUiTest1() {
        composeTestRule.onNodeWithTag("input").performTextInput("0")
        composeTestRule.onNodeWithTag("convertButton").performClick()
        composeTestRule.onNodeWithTag("hexValue").assertTextEquals("0")
        composeTestRule.onNodeWithTag("octalValue").assertTextEquals("0")
        composeTestRule.onNodeWithTag("binaryValue").assertTextEquals("0")
        composeTestRule.onNodeWithTag("invalidInput").assertTextEquals("")
    }

    @Test
    fun composeUiTest2() {
        composeTestRule.onNodeWithTag("input").performTextInput(Int.MAX_VALUE.toString())
        composeTestRule.onNodeWithTag("convertButton").performClick()
        composeTestRule.onNodeWithTag("hexValue").assertTextEquals("7fffffff")
        composeTestRule.onNodeWithTag("octalValue").assertTextEquals("17777777777")
        composeTestRule.onNodeWithTag("binaryValue").assertTextEquals("1111111111111111111111111111111")
        composeTestRule.onNodeWithTag("invalidInput").assertTextEquals("")
    }

    @Test
    fun composeUiEmpty() {
        composeTestRule.onNodeWithTag("convertButton").performClick()
        composeTestRule.onNodeWithTag("hexValue").assertTextEquals("")
        composeTestRule.onNodeWithTag("octalValue").assertTextEquals("")
        composeTestRule.onNodeWithTag("binaryValue").assertTextEquals("")

        val invalid = composeTestRule.activity.resources.getString(R.string.invalidInput)
        composeTestRule.onNodeWithTag("invalidInput").assertTextEquals(invalid)
    }

    @Test
    fun composeUiOvercharge() {
        composeTestRule.onNodeWithTag("input").performTextInput("99999999999999999999999")
        composeTestRule.onNodeWithTag("convertButton").performClick()
        composeTestRule.onNodeWithTag("hexValue").assertTextEquals("")
        composeTestRule.onNodeWithTag("octalValue").assertTextEquals("")
        composeTestRule.onNodeWithTag("binaryValue").assertTextEquals("")

        val invalid = composeTestRule.activity.resources.getString(R.string.invalidInput)
        composeTestRule.onNodeWithTag("invalidInput").assertTextEquals(invalid)
    }
}