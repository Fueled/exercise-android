package com.fueled.technicalchallenge.ui.records

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RecordsViewModel @Inject constructor(
) : ViewModel() {

    private val _state = MutableStateFlow(RecordsState())
    val state: StateFlow<RecordsState> = _state.asStateFlow()

    init {
        getRecordCollection()
    }

    private fun getRecordCollection() {
    }
}
