package life.league.challenge.kotlin.features.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import life.league.challenge.kotlin.R
import life.league.challenge.kotlin.core.ui.uicomponents.CircularImageView
import life.league.challenge.kotlin.core.ui.uicomponents.ErrorScreen
import life.league.challenge.kotlin.core.ui.uicomponents.LoadingScreen
import life.league.challenge.kotlin.features.home.domain.model.PostModel


@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.uiState.collectAsState().value
    val posts = state.postsList

    Surface(
        color = Color.White,
    ) {
        when {
            state.showLoading -> LoadingScreen()
            state.showError || posts.isNullOrEmpty() -> ErrorScreen { viewModel.onTryAgainClicked() }
            posts.isEmpty().not() -> HomePosts(posts = posts)
        }
    }
}

@Composable
fun HomePosts(posts: List<PostModel>) {
    LazyColumn {
        items(posts) { post ->
            PostItem(post)
            Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun PostItem(post: PostModel) {
    Surface {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CircularImageView(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(24.dp),
                    post.imageUrl,
                    stringResource(id = R.string.user_icon_description)
                )
                Text(text = post.userName)
            }
            Text(text = post.title, modifier = Modifier.padding(vertical = 8.dp))
            Text(text = post.description)
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(viewModel())
}