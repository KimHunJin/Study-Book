package com.dxmnd.mos.dev.recycler_view

import com.dxmnd.mos.dev.recycler_view.adapter.AdapterContract
import com.dxmnd.mos.dev.recycler_view.adapter.RecyclerViewAdapter
import dxmnd.com.rightnow.base.BasePresenter
import dxmnd.com.rightnow.base.BaseView


interface Contract {

    interface View : BaseView<Presenter> {
    }

    interface Presenter : BasePresenter {

        var adapterModel : AdapterContract.Model?

        var adapterView : AdapterContract.View?

        fun addItemClick(adapter: RecyclerViewAdapter)
    }
}