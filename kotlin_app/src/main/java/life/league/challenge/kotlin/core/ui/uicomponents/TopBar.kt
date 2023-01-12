package life.league.challenge.kotlin.core.ui.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import life.league.challenge.kotlin.core.directions.LeagueDirections
import life.league.challenge.kotlin.core.ui.resources.LeagueColors

@Composable
fun TopBar(modifier: Modifier = Modifier, currentScreen: LeagueDirections) {
    Surface(color = MaterialTheme.colorScheme.secondary) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = currentScreen.screenTitle),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 8.dp),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.dp)
        }
    }
}

@Composable
@Preview
fun TopBarPreview() {
    TopBar(currentScreen = LeagueDirections.Home)
}