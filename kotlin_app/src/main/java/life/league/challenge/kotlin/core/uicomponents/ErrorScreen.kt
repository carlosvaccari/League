package life.league.challenge.kotlin.core.uicomponents

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import life.league.challenge.kotlin.R

@Composable
fun ErrorScreen(errorAction: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(0.5F))
            Text(text = stringResource(id = R.string.error_title))
            Text(
                text = stringResource(id = R.string.error_description),
                modifier = Modifier.padding(top = 24.dp)
            )
            Spacer(modifier = Modifier.weight(1F))
            Button(
                onClick = { errorAction() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.error_action))
            }
        }
    }
}

@Composable
@Preview
fun ErrorScreenPreview() {
    ErrorScreen {}
}
