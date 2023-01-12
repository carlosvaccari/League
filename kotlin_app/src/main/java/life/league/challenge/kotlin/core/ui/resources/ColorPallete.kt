package life.league.challenge.kotlin.core.ui.resources

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

object ColorPallete {

    val LightColors = lightColorScheme(
        primary = Color(0xFFFFFFFF),
        onPrimary = Color(0xFF000000),
        secondary = Color(0xFFf9f9f9),
        onSecondary = Color(0xFF000000),
        tertiary = Color(0xFF2285d0),
        onTertiary = Color(0xFFFFFFFF)
    )

    val DarkColors = darkColorScheme(
        primary = Color(0xFF1C1B1F),
        onPrimary = Color(0xFFFFFFFF),
        secondary = Color(0x4D000000),
        onSecondary = Color(0xFFFFFFFF),
        tertiary = Color(0xFF2285d0),
        onTertiary = Color(0xFFFFFFFF)
    )
}