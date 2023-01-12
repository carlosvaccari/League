package life.league.challenge.kotlin.core.directions

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import life.league.challenge.kotlin.R
import life.league.challenge.kotlin.features.home.ui.HomeScreen

typealias DestinationScreen = @Composable () -> Unit

sealed class LeagueDirections(
    @StringRes val screenTitle: Int,
    val route: String,
    val screen: DestinationScreen
) {
    object Home : LeagueDirections(R.string.home_screen_title, "home", { HomeScreen(hiltViewModel()) })
}