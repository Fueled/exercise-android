package com.fueled.technicalchallenge.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fueled.technicalchallenge.BR

/**
 * Extension method to provide quicker access to the [LayoutInflater] from a [View].
 */
val View.layoutInflater
    get() = context.getLayoutInflater()

abstract class DataBindingAdapterDiff<T>(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, DataBindingViewHolder<T>>(diffCallback) {

    abstract override fun getItemViewType(position: Int): Int

    override fun onCreateViewHolder(
        parent: ViewGroup,
        @LayoutRes layoutId: Int
    ): DataBindingViewHolder<T> {
        return DataBindingViewHolder(parent.inflateBinding(layoutId))
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }
}

open class DataBindingViewHolder<T>(open val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    open fun bind(item: T) {
        binding.setVariable(BR.listItem, item)
    }
}

inline fun <reified T : ViewDataBinding> ViewGroup.inflateBinding(
    @LayoutRes layoutResId: Int,
    attachToParent: Boolean = false
): T {
    return DataBindingUtil.inflate(layoutInflater, layoutResId, this, attachToParent)
}