package life.league.challenge.kotlin.features.home.data

import life.league.challenge.kotlin.core.data.remote.RemoteDataSource
import life.league.challenge.kotlin.core.networkwrapper.DataResult
import life.league.challenge.kotlin.core.networkwrapper.asDataResult
import life.league.challenge.kotlin.features.home.data.model.PostNetwork
import life.league.challenge.kotlin.features.home.data.model.UserNetwork
import javax.inject.Inject

interface HomeRepository {
    suspend fun getPosts() : DataResult<List<PostNetwork>>
    suspend fun getUsers() : DataResult<List<UserNetwork>>
}

class HomeRepositoryImpl @Inject constructor(
    val remoteDataSource: RemoteDataSource
): HomeRepository {

    override suspend fun getPosts(): DataResult<List<PostNetwork>> {
        return remoteDataSource.getPosts().asDataResult()
    }

    override suspend fun getUsers(): DataResult<List<UserNetwork>> {
        return remoteDataSource.getUsers().asDataResult()
    }
}