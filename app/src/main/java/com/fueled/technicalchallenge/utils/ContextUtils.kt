package com.fueled.technicalchallenge.utils

import android.content.Context
import android.view.LayoutInflater

fun Context.getLayoutInflater() =
    getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
