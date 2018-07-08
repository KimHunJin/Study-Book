package dxmnd.com.rightnow.main.info.adapter

import android.content.Context
import android.view.ViewGroup
import dxmnd.com.rightnow.base.adapter.BaseAdapter
import dxmnd.com.rightnow.base.adapter.holder.BaseViewHolder
import dxmnd.com.rightnow.main.info.adapter.holder.BusInfoViewHolder
import dxmnd.com.rightnow.main.info.adapter.item.BusInfoItem
import dxmnd.com.rightnow.main.info.adapter.model.BusInfoContract

class InfoRecyclerVIewAdapter(context: Context) :
        BaseAdapter<BusInfoItem>(context), BusInfoContract.View, BusInfoContract.Model {

    override fun onItemViewType(position: Int): Int = getItems()[position].status

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BusInfoItem> = BusInfoViewHolder(parent, this)
}