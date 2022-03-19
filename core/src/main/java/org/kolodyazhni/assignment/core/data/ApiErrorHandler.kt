package org.kolodyazhni.assignment.core.data

import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.SingleTransformer
import org.kolodyazhni.assignment.core.data.dto.ApiErrorDto
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class ApiErrorHandler @Inject constructor(private val gson: Gson) {

    fun <T> get() = SingleTransformer<Response<T>, T> { single ->
        single.map { response ->
            if (response.isSuccessful) {
                response.body()
            } else {
                throw HttpException(response)
            }
        }.onErrorResumeNext { Single.error(wrapError(it)) }
    }

    private fun wrapError(th: Throwable): ApiException {
        return when (th) {
            is IOException -> {
                ApiException(message = "No internet connection")
            }
            is HttpException -> {
                val error = th.response()?.errorBody()?.let { errrorBody ->
                    val reader = errrorBody.byteStream().reader()
                    val error = gson.fromJson<ApiErrorDto>(reader, ApiErrorDto::class.java)
                    reader.close()
                    error
                }
                ApiException(message = error?.message ?: "Smth wrong", errorCode = error?.errorCode)
            }
            else -> ApiException(message = "Smth wrong")
        }
    }
}