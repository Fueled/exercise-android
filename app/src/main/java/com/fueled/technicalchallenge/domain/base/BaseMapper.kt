package com.fueled.technicalchallenge.domain.base

import com.fueled.technicalchallenge.data.api.model.ResponseApiModel

abstract class BaseMapper {

    fun <T> mapApiResult(result: ResponseApiModel<T>): T {
        return result.payload
    }
}
