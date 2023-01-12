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
    val api: Api
): RemoteDataSource {

    private var apiKey: String? = null

    override suspend fun getPosts(): NetworkResult<List<PostNetwork>> {
        return api.posts(getApiKey())
    }

    override suspend fun getUsers(): NetworkResult<List<UserNetwork>> {
        return api.users(getApiKey())
    }

    private suspend fun getApiKey() : String {
        // Todo store token somewhere
        if (apiKey == null) {
            apiKey = api.login("hello", "world").asSuccess()?.data?.apiKey
        }
        return apiKey.orEmpty()
    }
}