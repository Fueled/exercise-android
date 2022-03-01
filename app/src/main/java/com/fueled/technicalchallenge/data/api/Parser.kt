package com.fueled.technicalchallenge.data.api

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Type
import javax.inject.Inject

class Parser @Inject constructor(private val context: Context, val gson: Gson) {

    inline fun <reified T> type(): Type = object : TypeToken<T>() {}.type

    inline fun <reified T> parse(name: String): T {
        val jsonResponse = getJsonResponse(name)
        return gson.fromJson(jsonResponse, type<T>())
    }

    fun getJsonResponse(name: String): String {
        val resources = context.applicationContext.resources
        val resId = resources.getIdentifier(name, "raw", context.packageName)
        val inputStreamReader = InputStreamReader(resources.openRawResource(resId))
        return BufferedReader(inputStreamReader).use { it.readText() }
    }
}
