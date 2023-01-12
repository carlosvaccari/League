package life.league.challenge.kotlin.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import life.league.challenge.kotlin.features.home.injection.HomeModule
import life.league.challenge.kotlin.features.home.ui.HomeScreen
import life.league.challenge.kotlin.features.home.ui.HomeViewModel
import life.league.challenge.kotlin.home.fake.FakeGetPostsUseCase
import life.league.challenge.kotlin.main.MainActivity
import life.league.challenge.kotlin.utils.assertTextIsDisplayed
import life.league.challenge.kotlin.utils.withActivityContent
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class HomeScreenTest {

    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var fakeRemoteDataSource: FakeGetPostsUseCase

    @Before
    fun setup() {
        hiltTestRule.inject()
    }

    @Test
    fun checkListItemsAreShown() {
        composeTestRule
            .withActivityContent {
                HomeScreen(getViewModel(true))
            }
            .apply {
                assertTextIsDisplayed("title 1")
                assertTextIsDisplayed("title 2")
                assertTextIsDisplayed("description 1")
                assertTextIsDisplayed("description 2")
            }
    }


    @Test
    fun checkErrorScreenIsShown() {
        composeTestRule
            .withActivityContent {
                HomeScreen(getViewModel(false))
            }
            .apply {
                assertTextIsDisplayed("Error")
                assertTextIsDisplayed("We couldn\'t fetch your data. Please try again later.")
                assertTextIsDisplayed("Try again")
            }
    }

    @Composable
    private fun getViewModel(networkRequestWithSuccess: Boolean) =
        HomeViewModel(fakeRemoteDataSource.apply { returnSuccess = networkRequestWithSuccess })
}