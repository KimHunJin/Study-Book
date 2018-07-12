package com.dxmnd.mos.dev.recycler_view.adapter

import android.content.Context
import android.view.ViewGroup
import com.dxmnd.mos.dev.recycler_view.adapter.data.RecyclerViewItem
import com.dxmnd.mos.dev.recycler_view.adapter.holder.RecyclerViewHolder
import dxmnd.com.rightnow.base.adapter.BaseAdapter
import dxmnd.com.rightnow.base.adapter.holder.BaseViewHolder


class RecyclerViewAdapter(context: Context)
    : BaseAdapter<RecyclerViewItem>(context), AdapterContract.Model, AdapterContract.View {

    override fun onItemViewType(position: Int): Int = getItems()[position].id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : BaseViewHolder<RecyclerViewItem> = RecyclerViewHolder(parent, this)

}