package com.fueled.technicalchallenge.data.api

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class CrmApi @Inject constructor(val parser: Parser) {

    inline fun <reified T> getGroupInfo(): Flow<T> = getData(ENDPOINT_INFO)

    inline fun <reified T> getGroupMeta(): Flow<T> = getData(ENDPOINT_META)

    inline fun <reified T> getGroupData(): Flow<T> = getData(ENDPOINT_OBJECTS)

    inline fun <reified T> getData(endpointName: String): Flow<T> = flowOf(parser.parse(endpointName))

}
