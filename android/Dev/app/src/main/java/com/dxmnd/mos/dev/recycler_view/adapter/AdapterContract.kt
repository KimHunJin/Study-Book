package com.dxmnd.mos.dev.recycler_view.adapter

import com.dxmnd.mos.dev.recycler_view.adapter.model.RecyclerViewModel
import dxmnd.com.rightnow.base.adapter.model.BaseRecyclerView


interface AdapterContract {
    interface View : BaseRecyclerView

    interface Model : RecyclerViewModel
}