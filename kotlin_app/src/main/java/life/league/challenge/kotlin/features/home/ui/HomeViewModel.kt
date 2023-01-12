package life.league.challenge.kotlin.features.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import life.league.challenge.kotlin.core.networkwrapper.onException
import life.league.challenge.kotlin.core.networkwrapper.onSuccess
import life.league.challenge.kotlin.features.home.domain.GetPostsUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> =
        MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        fetchData()
    }

    fun onTryAgainClicked() = fetchData()

    private fun fetchData() {
        viewModelScope.launch {
            _uiState.update { it.copy(showLoading = true) }
            getPostsUseCase.invoke()
                .onSuccess { posts ->
                    _uiState.update {
                        it.copy(
                            postsList = posts,
                            showLoading = false,
                            showError = false
                        )
                    }
                }
                .onException {
                    _uiState.update { it.copy(showError = true, showLoading = false) }
                }
        }
    }
}