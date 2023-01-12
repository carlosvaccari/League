package life.league.challenge.kotlin.home

import life.league.challenge.kotlin.core.data.remote.exceptions.NoPostsFoundException
import life.league.challenge.kotlin.features.home.data.model.PostNetwork
import life.league.challenge.kotlin.features.home.data.model.UserNetwork
import life.league.challenge.kotlin.features.home.domain.model.PostModel

val SOME_TITLE = "title"
val SOME_DESCRIPTION = "description"
val SOME_AVATAR_URL = "avatarUrl"
val SOME_NAME = "name"

val postsNetwork = listOf(
    PostNetwork(1, SOME_TITLE, SOME_DESCRIPTION),
    PostNetwork(2, SOME_TITLE, SOME_DESCRIPTION),
    PostNetwork(3, SOME_TITLE, SOME_DESCRIPTION),
)

val usersNetwork = listOf(
    UserNetwork(1, SOME_AVATAR_URL, SOME_NAME),
    UserNetwork(2, SOME_AVATAR_URL, SOME_NAME),
    UserNetwork(3, SOME_AVATAR_URL, SOME_NAME),
)

val postsModel = listOf(
    PostModel(1, SOME_AVATAR_URL, SOME_NAME, SOME_TITLE, SOME_DESCRIPTION),
    PostModel(2, SOME_AVATAR_URL, SOME_NAME, SOME_TITLE, SOME_DESCRIPTION),
    PostModel(3, SOME_AVATAR_URL, SOME_NAME, SOME_TITLE, SOME_DESCRIPTION),
)

val noPostsFoundException = NoPostsFoundException()