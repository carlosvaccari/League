package life.league.challenge.kotlin.home.data

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import life.league.challenge.kotlin.core.data.remote.RemoteDataSource
import life.league.challenge.kotlin.core.networkwrapper.DataResult
import life.league.challenge.kotlin.core.networkwrapper.NetworkResult
import life.league.challenge.kotlin.core.networkwrapper.asSuccess
import life.league.challenge.kotlin.features.home.data.HomeRepository
import life.league.challenge.kotlin.features.home.data.HomeRepositoryImpl
import life.league.challenge.kotlin.home.postsNetwork
import life.league.challenge.kotlin.home.usersNetwork
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeRepositoryTest {

    private val remoteDataSource = mockk<RemoteDataSource>()

    private val subject: HomeRepository = HomeRepositoryImpl(
        remoteDataSource = remoteDataSource
    )

    @Test
    fun `getPosts should map NetworkResult to DataResult`() = runBlocking {
        // GIVEN
        coEvery { remoteDataSource.getPosts() } returns NetworkResult.Success(postsNetwork)

        // WHEN
        val result = subject.getPosts()

        // THEN
        assertTrue(result is DataResult.Success)
        assertEquals(result.asSuccess().data, postsNetwork)
    }

    @Test
    fun `getUsers should map NetworkResult to DataResult`() = runBlocking {
        // GIVEN
        coEvery { remoteDataSource.getUsers() } returns NetworkResult.Success(usersNetwork)

        // WHEN
        val result = subject.getUsers()

        // THEN
        assertTrue(result is DataResult.Success)
        assertEquals(result.asSuccess().data, usersNetwork)
    }
}