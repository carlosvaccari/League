package life.league.challenge.kotlin.core.ui.uicomponents

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import life.league.challenge.kotlin.R

@Composable
fun ErrorScreen(errorAction: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(0.5F))
        Text(
            text = stringResource(id = R.string.error_title),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(
                id = R.string.error_description,
            ),
            modifier = Modifier.padding(top = 24.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.weight(1F))
        Button(
            onClick = { errorAction() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onTertiary,
            )
        ) {
            Text(text = stringResource(id = R.string.error_action))
        }
    }
}

@Composable
@Preview
fun ErrorScreenPreview() {
    ErrorScreen {}
}
