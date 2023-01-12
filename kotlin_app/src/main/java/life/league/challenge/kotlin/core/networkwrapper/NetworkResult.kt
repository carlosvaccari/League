package life.league.challenge.kotlin.core.networkwrapper

/**
 *  This code is not mine. This is a network wrapper that I have been working with for a while
 *  and it helps handling error of network requests
 *  For more information, please check:
 *  https://proandroiddev.com/modeling-retrofit-responses-with-sealed-classes-and-coroutines-9d6302077dfe
 */
sealed class NetworkResult<T : Any> {
    class Success<T : Any>(val data: T) : NetworkResult<T>()
    class Error<T : Any>(val code: Int, val message: String?) : NetworkResult<T>()
    class Exception<T : Any>(val exception: Throwable) : NetworkResult<T>()
}

fun <T : Any> NetworkResult<T>.asDataResult(): DataResult<T> {
    return when (this) {
        is NetworkResult.Success -> DataResult.Success(this.data)
        is NetworkResult.Error -> DataResult.Error(this.code, this.message)
        is NetworkResult.Exception -> DataResult.Exception(this.exception)
    }
}

fun <T: Any> NetworkResult<T>.asSuccess() : NetworkResult.Success<T>? {
    return this as? NetworkResult.Success
}