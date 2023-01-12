package life.league.challenge.kotlin.core.networkwrapper

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 *  This code is not mine. This is a network wrapper that I have been working with for a while
 *  and it helps handling error of network requests
 *  For more information, please check:
 *  https://proandroiddev.com/modeling-retrofit-responses-with-sealed-classes-and-coroutines-9d6302077dfe
 */
class NetworkResultCallAdapter(
    private val resultType: Type
) : CallAdapter<Type, Call<NetworkResult<Type>>> {

    override fun responseType(): Type = resultType

    override fun adapt(call: Call<Type>): Call<NetworkResult<Type>> {
        return NetworkResultCall(call)
    }
}