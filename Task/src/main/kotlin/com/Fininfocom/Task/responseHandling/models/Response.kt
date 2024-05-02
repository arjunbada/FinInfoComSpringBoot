package com.Fininfocom.Task.responseHandling.models

data class Response<T>(
    var status: Boolean = false,
    val message: String? = null,
    var data: T? = null
)