package life.league.challenge.kotlin.utils

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule

fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>.withActivityContent(
    content: @Composable () -> Unit
): ComposeTestRule {
    activity.setContent { content() }
    return this
}

fun ComposeContentTestRule.withContent(content: @Composable () -> Unit): ComposeTestRule {
    setContent { content() }
    return this
}

fun ComposeTestRule.assertTextIsDisplayed(text: String): SemanticsNodeInteraction {
    return this.onNodeWithText(text).assertIsDisplayed()
}