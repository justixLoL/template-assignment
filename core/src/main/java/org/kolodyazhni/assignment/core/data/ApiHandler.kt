package org.kolodyazhni.assignment.core.data

import io.reactivex.SingleTransformer
import retrofit2.Response
import javax.inject.Inject

class ApiHandler @Inject constructor(private val errorHandler: ApiErrorHandler) {

    fun <T> get(): SingleTransformer<Response<T>, T> = SingleTransformer { single ->
        single.compose(errorHandler.get())
    }
}