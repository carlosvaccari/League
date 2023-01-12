package life.league.challenge.kotlin.home.domain

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import life.league.challenge.kotlin.core.exceptions.NoPostsFoundException
import life.league.challenge.kotlin.core.networkwrapper.DataResult
import life.league.challenge.kotlin.core.networkwrapper.asException
import life.league.challenge.kotlin.core.networkwrapper.asSuccess
import life.league.challenge.kotlin.features.home.data.HomeRepository
import life.league.challenge.kotlin.features.home.domain.GetPostsUseCase
import life.league.challenge.kotlin.features.home.domain.GetPostsUseCaseImpl
import life.league.challenge.kotlin.home.postsModel
import life.league.challenge.kotlin.home.postsNetwork
import life.league.challenge.kotlin.home.usersNetwork
import life.league.challenge.kotlin.utils.MainTestRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class GetPostsUseCaseTest {

    private val repository = mockk<HomeRepository>()

    @get:Rule //TODO check this
    val rule = MainTestRule()

    private val subject: GetPostsUseCase = GetPostsUseCaseImpl(
        homeRepository = repository,
        dispatchProvider = rule.contextProvider
    )

    @Test
    fun `data is mapped correctly when successfully requesting data from network`() = runBlocking {
        // GIVEN
        `answers network calls with success`()

        // WHEN
        val result = subject.invoke()

        // THEN
        assertEquals(postsModel, result.asSuccess().data)
    }

    @Test
    fun `returns exception when getPosts call fails`() = runBlocking {
        // GIVEN
        `answers only getPosts call with success`()

        // WHEN
        val result = subject.invoke()

        // THEN
        assertTrue(result.asException().e is NoPostsFoundException)
    }

    @Test
    fun `returns exception when getUsers call fails`() = runBlocking {
        // GIVEN
        `answers only getUsers call with success`()

        // WHEN
        val result = subject.invoke()

        // THEN
        assertTrue(result.asException().e is NoPostsFoundException)
    }

    private fun `answers network calls with success`() {
        coEvery { repository.getPosts() } returns DataResult.Success(postsNetwork)
        coEvery { repository.getUsers() } returns DataResult.Success(usersNetwork)
    }

    private fun `answers only getPosts call with success`() {
        coEvery { repository.getPosts() } returns DataResult.Success(postsNetwork)
        coEvery { repository.getUsers() } returns DataResult.Exception(Exception())
    }

    private fun `answers only getUsers call with success`() {
        coEvery { repository.getPosts() } returns DataResult.Exception(Exception())
        coEvery { repository.getUsers() } returns DataResult.Success(usersNetwork)
    }

}