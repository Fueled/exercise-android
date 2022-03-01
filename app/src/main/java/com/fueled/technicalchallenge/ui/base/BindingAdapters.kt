package com.fueled.technicalchallenge.ui.base

import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fueled.technicalchallenge.R
import com.fueled.technicalchallenge.domain.model.FieldList
import com.fueled.technicalchallenge.ui.widget.FieldItemWidget
import com.fueled.technicalchallenge.utils.DataBindingAdapterDiff

@BindingAdapter("setFields")
fun LinearLayout.setFields(fields: FieldList) {
    removeAllViews()
    fields.map { field ->
        FieldItemWidget(context).apply {
            bind(field)
        }
    }.forEach { view -> addView(view) }
}

@BindingAdapter("setListItems")
fun <T> RecyclerView.setListItems(listItems: List<T>?) {
    (this.adapter as DataBindingAdapterDiff<T>).submitList(listItems)
}

@BindingAdapter("bindFieldAlias")
fun TextView.bindFieldAlias(alias: String) {
    this.text = context.getString(R.string.field_alias, alias)
}
