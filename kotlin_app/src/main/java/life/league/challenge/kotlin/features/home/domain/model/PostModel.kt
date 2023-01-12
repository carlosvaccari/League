package life.league.challenge.kotlin.features.home.domain.model

data class PostModel(
    val userId: Int,
    val imageUrl: String,
    val userName: String,
    val title: String,
    val description: String
)