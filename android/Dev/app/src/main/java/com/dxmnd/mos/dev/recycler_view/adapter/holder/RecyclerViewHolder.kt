package com.dxmnd.mos.dev.recycler_view.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.dxmnd.mos.dev.R
import com.dxmnd.mos.dev.recycler_view.adapter.data.RecyclerViewItem
import dxmnd.com.rightnow.base.adapter.holder.BaseViewHolder
import kotlinx.android.synthetic.main.item_recycler_view.view.*


class RecyclerViewHolder(parent: ViewGroup?, adapter: RecyclerView.Adapter<*>)
    : BaseViewHolder<RecyclerViewItem>(R.layout.item_recycler_view, parent, adapter) {
    override fun onBindViewHolder(item: RecyclerViewItem?, position: Int) {
        item?.let {
            itemView.txt_item_recycler_view.text = it.text
        }
    }
}