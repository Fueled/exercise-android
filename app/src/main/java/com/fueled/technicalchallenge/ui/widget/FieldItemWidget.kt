package com.fueled.technicalchallenge.ui.widget

import android.content.Context
import android.widget.FrameLayout
import com.fueled.technicalchallenge.R
import com.fueled.technicalchallenge.databinding.WidgetFieldItemBinding
import com.fueled.technicalchallenge.domain.model.Field
import com.fueled.technicalchallenge.ui.base.BindViewGroup

class FieldItemWidget(context: Context) : FrameLayout(context) {

    private val binding: WidgetFieldItemBinding by BindViewGroup(R.layout.widget_field_item)

    fun bind(field: Field) {
        binding.field = field
    }
}
