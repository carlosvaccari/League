package life.league.challenge.kotlin.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import life.league.challenge.kotlin.core.data.remote.coroutine.CoroutineDispatchProvider
import org.junit.runner.Description

@OptIn(ExperimentalCoroutinesApi::class)
class MainTestRule : InstantTaskExecutorRule() {

    val dispatcher = UnconfinedTestDispatcher()
    val contextProvider = object : CoroutineDispatchProvider {
        override val main = dispatcher
        override val mainImmediate = dispatcher
        override val io = dispatcher
        override val default = dispatcher
    }

    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}