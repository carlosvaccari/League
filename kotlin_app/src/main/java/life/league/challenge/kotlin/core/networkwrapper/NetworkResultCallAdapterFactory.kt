package life.league.challenge.kotlin.core.networkwrapper

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 *  This code is not mine. This is a network wrapper that I have been working with for a while
 *  and it helps handling error of network requests
 *  For more information, please check:
 *  https://proandroiddev.com/modeling-retrofit-responses-with-sealed-classes-and-coroutines-9d6302077dfe
 */
class NetworkResultCallAdapterFactory private constructor() : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) {
            return null
        }

        val callType = getParameterUpperBound(0, returnType as ParameterizedType)
        if (getRawType(callType) != NetworkResult::class.java) {
            return null
        }

        val resultType = getParameterUpperBound(0, callType as ParameterizedType)
        return NetworkResultCallAdapter(resultType)
    }

    companion object {
        fun create(): NetworkResultCallAdapterFactory = NetworkResultCallAdapterFactory()
    }
}