package org.kolodyazhni.assignment.core.data.dto

data class ApiErrorDto(val message: String?,
                       val developerMessage: String,
                       val errorCode: String)