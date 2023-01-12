package life.league.challenge.kotlin.home.fake

import life.league.challenge.kotlin.core.data.remote.exceptions.NoPostsFoundException
import life.league.challenge.kotlin.core.networkwrapper.DataResult
import life.league.challenge.kotlin.features.home.domain.GetPostsUseCase
import life.league.challenge.kotlin.features.home.domain.model.PostModel
import javax.inject.Inject

class FakeGetPostsUseCase @Inject constructor() : GetPostsUseCase {

    var returnSuccess: Boolean = true

    override suspend fun invoke(): DataResult<List<PostModel>> {
        return if (returnSuccess) {
            DataResult.Success(
                listOf(
                    PostModel(
                        1,
                        "imageUrl 1",
                        "name 1",
                        "title 1",
                        "description 1"
                    ),
                    PostModel(
                        2,
                        "imageUrl 2",
                        "name 2",
                        "title 2",
                        "description 2"
                    )
                )
            )
        } else {
            DataResult.Exception(NoPostsFoundException())
        }
    }
}