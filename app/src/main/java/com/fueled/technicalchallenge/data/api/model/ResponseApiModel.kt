package com.fueled.technicalchallenge.data.api.model

data class ResponseApiModel<T>(
    val status: String,
    val payload: T,
    val userId: String
)
