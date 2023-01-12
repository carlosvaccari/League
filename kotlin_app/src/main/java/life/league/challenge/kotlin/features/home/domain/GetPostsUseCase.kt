package life.league.challenge.kotlin.features.home.domain

import kotlinx.coroutines.withContext
import life.league.challenge.kotlin.core.data.remote.coroutine.CoroutineDispatchProvider
import life.league.challenge.kotlin.core.exceptions.NoPostsFoundException
import life.league.challenge.kotlin.core.networkwrapper.DataResult
import life.league.challenge.kotlin.core.networkwrapper.asSuccess
import life.league.challenge.kotlin.core.networkwrapper.isSuccess
import life.league.challenge.kotlin.features.home.data.HomeRepository
import life.league.challenge.kotlin.features.home.domain.model.PostModel
import javax.inject.Inject

interface GetPostsUseCase {
    suspend fun invoke(): DataResult<List<PostModel>>
}

class GetPostsUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository,
    private val dispatchProvider: CoroutineDispatchProvider,
) : GetPostsUseCase {

    override suspend fun invoke(): DataResult<List<PostModel>> {
        return withContext(dispatchProvider.io) {
            val postsResult = homeRepository.getPosts()
            val usersResult = homeRepository.getUsers()

            if (postsResult.isSuccess() && usersResult.isSuccess()) {
                val associatedToIdUsers = usersResult.asSuccess().data.associateBy { it.id }
                DataResult.Success(postsResult.asSuccess().data.map { post ->
                    val currentUser = associatedToIdUsers[post.userId]
                    PostModel(
                        userId = post.userId,
                        imageUrl = currentUser?.avatar.orEmpty(),
                        userName = currentUser?.name.orEmpty(),
                        title = post.title,
                        description = post.body
                    )
                })
            } else {
                DataResult.Exception(NoPostsFoundException())
            }
        }
    }
}