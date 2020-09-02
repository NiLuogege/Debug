package com.niluogege.debug.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.niluogege.debug.R

class PagingAdapter : PagingDataAdapter<PagingItem, PagingViewHolder>(COMPARATOR) {

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<PagingItem>() {
            override fun areContentsTheSame(oldItem: PagingItem, newItem: PagingItem): Boolean = oldItem == newItem

            override fun areItemsTheSame(oldItem: PagingItem, newItem: PagingItem): Boolean =
                    oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return PagingViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.tv.text = item.name
            holder.btn.text = item.age
        }
    }


}

class PagingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tv = itemView.findViewById<TextView>(R.id.tv)
    val btn = itemView.findViewById<Button>(R.id.btn)

}