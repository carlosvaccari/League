package life.league.challenge.kotlin.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import life.league.challenge.kotlin.core.directions.LeagueDirections
import life.league.challenge.kotlin.core.ui.theme.LeagueTheme
import life.league.challenge.kotlin.core.ui.uicomponents.TopBar

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeagueApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeagueApp() {
    LeagueTheme {
        val currentScreen: LeagueDirections by remember { mutableStateOf(LeagueDirections.Home) }
        Scaffold(
            topBar = {
                TopBar(
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            Box(Modifier.padding(innerPadding)) {
                currentScreen.screen()
            }
        }
    }
}
