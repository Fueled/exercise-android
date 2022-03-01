package com.fueled.technicalchallenge.ui.records

import com.fueled.technicalchallenge.domain.model.Record

data class RecordsState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
    val collectionTitle: String = "",
    val records: List<Record> = emptyList()
)
