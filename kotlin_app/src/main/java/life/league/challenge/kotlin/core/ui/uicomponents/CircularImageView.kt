package life.league.challenge.kotlin.core.ui.uicomponents

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import life.league.challenge.kotlin.core.ui.resources.LeagueColors

@Composable
fun CircularImageView(modifier: Modifier = Modifier, imageUrl: String, contentDescription: String) {
    Surface {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .clip(CircleShape)
                .border(0.5.dp, LeagueColors.Gray, CircleShape)
        )
    }
}
