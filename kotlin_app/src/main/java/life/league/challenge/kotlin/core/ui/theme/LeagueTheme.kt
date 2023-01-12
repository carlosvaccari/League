package life.league.challenge.kotlin.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun LeagueTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // TODO corrigir
//    val colors = when (darkTheme) {
//        false -> ColorPallete.LightColors
//        else -> ColorPallete.DarkColors
//    }

    MaterialTheme(
//        colorScheme = colors,
//        typography = typo,
        content = content
    )

}