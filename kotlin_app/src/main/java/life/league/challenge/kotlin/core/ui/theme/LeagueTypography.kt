package life.league.challenge.kotlin.core.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val typography = androidx.compose.material3.Typography(
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
    )
)