package life.league.challenge.kotlin.uicomponents

import androidx.compose.ui.test.junit4.createComposeRule
import life.league.challenge.kotlin.core.directions.LeagueDirections
import life.league.challenge.kotlin.core.ui.uicomponents.TopBar
import life.league.challenge.kotlin.utils.assertTextIsDisplayed
import life.league.challenge.kotlin.utils.withContent
import org.junit.Rule
import org.junit.Test

class TopBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun checkScreenTitleIsShown() {
        composeTestRule
            .withContent {
                TopBar(currentScreen = LeagueDirections.Home)
            }.assertTextIsDisplayed(HOME_SCREEN_TITLE)
    }

    companion object {
        private const val HOME_SCREEN_TITLE = "Posts"
    }
}