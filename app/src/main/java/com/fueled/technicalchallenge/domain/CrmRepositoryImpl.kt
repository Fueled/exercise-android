package com.fueled.technicalchallenge.domain

import com.fueled.technicalchallenge.data.api.CrmApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CrmRepositoryImpl @Inject constructor(
    private val crmApi: CrmApi,
    private val mapper: CrmRepositoryMapper,
) : CrmRepository {

    override fun getRecordCollection(): Flow<*> {
        TODO("Not yet implemented")
    }

}
