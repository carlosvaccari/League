package life.league.challenge.kotlin.core.networkwrapper

sealed class DataResult<T> {
    class Success<T>(val data: T) : DataResult<T>()
    class Error<T>(val code: Int, val message: String?) : DataResult<T>()
    class Exception<T>(val e: Throwable) : DataResult<T>()
}

fun <T> DataResult<T>.isSuccess() : Boolean {
    return this is DataResult.Success
}

fun <T> DataResult<T>.asSuccess() : DataResult.Success<T> {
    return this as DataResult.Success
}

fun <T> DataResult<T>.asException() : DataResult.Exception<T> {
    return this as DataResult.Exception
}

suspend fun <T : Any> DataResult<T>.onSuccess(
    executable: suspend (T) -> Unit
): DataResult<T> = apply {
    if (this is DataResult.Success<T>) {
        executable(data)
    }
}

suspend fun <T : Any> DataResult<T>.onException(
    executable: suspend (e: Throwable) -> Unit
): DataResult<T> = apply {
    if (this is DataResult.Exception<T>) {
        executable(e)
    }
}