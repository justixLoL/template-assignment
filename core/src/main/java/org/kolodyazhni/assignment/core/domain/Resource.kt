package org.kolodyazhni.assignment.core.domain

sealed class Resource<T> {
    abstract val data: T?

    data class Loading<T> internal constructor(override val data: T?) : Resource<T>()
    data class Error<T> internal constructor(override val data: T?, val errorMessage: String?) : Resource<T>()
    data class Success<T> internal constructor(override val data: T) : Resource<T>()

    companion object {
        fun <T> newLoading(): Resource<T> = Loading(null)
        fun <T> newSuccess(data: T): Resource<T> = Success(data)
        fun <T> newError(errorMessage: String?): Resource<T> = Error(null, errorMessage)
    }


    fun onLoading(): Resource<T> = Loading(data)
    fun onSuccess(newData: T): Resource<T> = Success(newData)
    fun onError(errorMessage: String?): Resource<T> = Error(data, errorMessage)
}