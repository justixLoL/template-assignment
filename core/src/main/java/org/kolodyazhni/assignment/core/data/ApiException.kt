package org.kolodyazhni.assignment.core.data

class ApiException(message: String? = null, val errorCode: String? = null) : Throwable(message)