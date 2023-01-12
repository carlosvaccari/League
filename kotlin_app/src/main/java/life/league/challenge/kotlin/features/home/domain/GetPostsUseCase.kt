package life.league.challenge.kotlin.features.home.domain

import kotlinx.coroutines.async
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
            val postsResult = async { homeRepository.getPosts() } //todo testar esse async
            val usersResult = async { homeRepository.getUsers() }

            val posts = postsResult.await()
            val users = usersResult.await()

            if (posts.isSuccess() && users.isSuccess()) {
                val associatedToIdUsers = users.asSuccess().data.associateBy { it.id }
                DataResult.Success(posts.asSuccess().data.map { post ->
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
                println(">>> exception")
                DataResult.Exception(NoPostsFoundException())
            }
        }
    }
}