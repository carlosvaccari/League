package life.league.challenge.kotlin.features.home.ui

import life.league.challenge.kotlin.features.home.domain.model.PostModel

data class HomeUiState(
    val showLoading: Boolean = true,
    val postsList: List<PostModel>? = null,
    val showError: Boolean = false
)