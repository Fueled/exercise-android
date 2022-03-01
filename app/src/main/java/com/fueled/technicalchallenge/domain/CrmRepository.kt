package com.fueled.technicalchallenge.domain

import kotlinx.coroutines.flow.Flow

interface CrmRepository {

    fun getRecordCollection(): Flow<*>
}
