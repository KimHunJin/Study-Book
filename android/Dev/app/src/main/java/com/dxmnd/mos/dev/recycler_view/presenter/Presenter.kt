package com.dxmnd.mos.dev.recycler_view.presenter

import com.dxmnd.mos.dev.recycler_view.Contract
import com.dxmnd.mos.dev.recycler_view.adapter.AdapterContract
import com.dxmnd.mos.dev.recycler_view.adapter.data.RecyclerViewItem

class Presenter(val view: Contract.View) : Contract.Presenter {

    override var adapterModel: AdapterContract.Model? = null
    override var adapterView: AdapterContract.View? = null

    override fun addItemClick() {
        adapterModel?.apply {
            addItem(makeItem())
        }
    }

    init {
        view.presenter = this
    }

    private fun makeItem(): RecyclerViewItem {
        val random = (Math.random()*10+1).toInt()
        return RecyclerViewItem(random, "추가 $random")
    }
}