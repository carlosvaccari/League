package life.league.challenge.kotlin.uicomponents

import androidx.compose.ui.test.junit4.createComposeRule
import life.league.challenge.kotlin.core.ui.uicomponents.ErrorScreen
import life.league.challenge.kotlin.utils.assertTextIsDisplayed
import life.league.challenge.kotlin.utils.withContent
import org.junit.Rule
import org.junit.Test

class ErrorScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun checkErrorScreenShowsInfo() {
        composeTestRule
            .withContent {
                ErrorScreen {}
            }.apply {
                assertTextIsDisplayed(ERROR_TITLE)
                assertTextIsDisplayed(ERROR_MESSAGE)
                assertTextIsDisplayed(ERROR_ACTION)
            }
    }

    private companion object {
        const val ERROR_TITLE = "Error"
        const val ERROR_MESSAGE = "We couldn\'t fetch your data. Please try again later."
        const val ERROR_ACTION = "Try again"
    }
}