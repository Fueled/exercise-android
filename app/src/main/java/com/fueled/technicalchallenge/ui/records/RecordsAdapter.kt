package com.fueled.technicalchallenge.ui.records

import androidx.recyclerview.widget.DiffUtil
import com.fueled.technicalchallenge.R
import com.fueled.technicalchallenge.domain.model.Record
import com.fueled.technicalchallenge.utils.DataBindingAdapterDiff

class RecordsAdapter : DataBindingAdapterDiff<Record>(RecordDiffCallback()) {
    override fun getItemViewType(position: Int): Int = R.layout.list_item_record
}

private class RecordDiffCallback : DiffUtil.ItemCallback<Record>() {
    override fun areItemsTheSame(oldItem: Record, newItem: Record): Boolean {
        return oldItem.uuid == newItem.uuid
    }

    override fun areContentsTheSame(oldItem: Record, newItem: Record): Boolean {
        return oldItem.fields.rawContent() == newItem.fields.rawContent()
    }
}
