package com.fueled.technicalchallenge.domain.model

class FieldList(items: List<Field>) : ArrayList<Field>(items) {
    fun rawContent(): String =
        joinToString { field -> "${field.alias}${field.displayValue}${field.rawValue}" }
}