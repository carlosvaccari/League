package life.league.challenge.kotlin.core.data.remote

import life.league.challenge.kotlin.core.data.remote.api.Api
import life.league.challenge.kotlin.core.data.remote.api.login
import life.league.challenge.kotlin.core.networkwrapper.NetworkResult
import life.league.challenge.kotlin.core.networkwrapper.asSuccess
import life.league.challenge.kotlin.features.home.data.model.PostNetwork
import life.league.challenge.kotlin.features.home.data.model.UserNetwork
import javax.inject.Inject

interface RemoteDataSource {
    suspend fun getPosts(): NetworkResult<List<PostNetwork>>
    suspend fun getUsers(): NetworkResult<List<UserNetwork>>
}

class RemoteDataSourceImpl @Inject constructor(
    private val api: Api
): RemoteDataSource {

    private var apiKey: String? = null

    override suspend fun getPosts(): NetworkResult<List<PostNetwork>> {
        return api.posts(getApiKey())
    }

    override suspend fun getUsers(): NetworkResult<List<UserNetwork>> {
        return api.users(getApiKey())
    }

    /**
     *  My understanding is that this is not the main goal of this test, so I've added this
     *  workaround instead of storing the token.
     */
    private suspend fun getApiKey() : String {
        if (apiKey == null) {
            apiKey = api.login(USERNAME, PASSWORD).asSuccess()?.data?.apiKey
        }
        return apiKey.orEmpty()
    }

    private companion object {
        const val USERNAME = "hello"
        const val PASSWORD = "world"
    }
}