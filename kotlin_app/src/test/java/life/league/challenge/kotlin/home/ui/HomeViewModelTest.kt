package life.league.challenge.kotlin.home.ui

import io.mockk.coEvery
import io.mockk.mockk
import life.league.challenge.kotlin.core.networkwrapper.DataResult
import life.league.challenge.kotlin.features.home.domain.GetPostsUseCase
import life.league.challenge.kotlin.features.home.ui.HomeViewModel
import life.league.challenge.kotlin.home.noPostsFoundException
import life.league.challenge.kotlin.home.postsModel
import life.league.challenge.kotlin.utils.MainTestRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val rule = MainTestRule()

    private val useCase = mockk<GetPostsUseCase>()

    private lateinit var subject: HomeViewModel

    @Test
    fun `when getting posts with success, should update uiState`() {
        // GIVEN
        `returns posts with success`()

        // WHEN
        initSubject()

        // THEN
        subject.uiState.value.let {
            assertEquals(false, it.showError)
            assertEquals(false, it.showLoading)
            assertEquals(postsModel, it.postsList)
        }
    }

    @Test
    fun `when tapping on tryAgain on error screen, should update uiState posts list and loading`() {
        // GIVEN
        `returns posts with success`()

        // WHEN
        initSubject()

        // THEN
        subject.uiState.value.let {
            assertEquals(false, it.showError)
            assertEquals(false, it.showLoading)
            assertEquals(postsModel, it.postsList)
        }
    }

    @Test
    fun `when getPosts fails, should update uiState showError and loading`() {
        // GIVEN
        coEvery { useCase.invoke() } returns DataResult.Exception(noPostsFoundException)

        // WHEN
        initSubject()
        subject.onTryAgainClicked()

        // THEN
        subject.uiState.value.let {
            assertEquals(true, it.showError)
            assertEquals(false, it.showLoading)
        }
    }

    private fun `returns posts with success`() {
        coEvery { useCase.invoke() } returns DataResult.Success(postsModel)
    }

    private fun initSubject() {
        subject = HomeViewModel(
            getPostsUseCase = useCase
        )
    }
}