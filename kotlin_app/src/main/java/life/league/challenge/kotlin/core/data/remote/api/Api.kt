package life.league.challenge.kotlin.core.data.remote.api

import life.league.challenge.kotlin.core.networkwrapper.NetworkResult
import life.league.challenge.kotlin.features.home.data.model.PostNetwork
import life.league.challenge.kotlin.features.home.data.model.UserNetwork
import life.league.challenge.kotlin.core.data.remote.model.AccountNetwork
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Retrofit API interface definition using coroutines. Feel free to change this implementation to
 * suit your chosen architecture pattern and concurrency tools
 */
interface Api {

    @GET("login")
    suspend fun login(@Header("Authorization") credentials: String?): NetworkResult<AccountNetwork>

    @GET("posts")
    suspend fun posts(@Header("x-access-token") accessToken: String): NetworkResult<List<PostNetwork>> // todo adicionar header em header interceptor

    @GET("users")
    suspend fun users(@Header("x-access-token") accessToken: String): NetworkResult<List<UserNetwork>>

}

/**
 * Overloaded Login API extension function to handle authorization header encoding
 */
suspend fun Api.login(username: String, password: String) = login(
    "Basic " + android.util.Base64.encodeToString(
        "$username:$password".toByteArray(),
        android.util.Base64.NO_WRAP
    )
)