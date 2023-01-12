package life.league.challenge.kotlin.core.data.remote.coroutine

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

interface CoroutineDispatchProvider {
    val main: CoroutineContext
    val mainImmediate: CoroutineContext
    val io: CoroutineContext
    val default: CoroutineContext

    class CoroutineDispatchers : CoroutineDispatchProvider {
        override val main = Dispatchers.Main
        override val mainImmediate = Dispatchers.Main.immediate
        override val io = Dispatchers.IO
        override val default = Dispatchers.Default
    }
}