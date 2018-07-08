package dxmnd.com.rightnow.main.info.adapter.model

import dxmnd.com.rightnow.base.adapter.model.BaseModel
import dxmnd.com.rightnow.base.adapter.model.BaseRecyclerView
import dxmnd.com.rightnow.main.info.adapter.item.BusInfoItem

interface BusInfoContract {
    interface View : BaseRecyclerView

    interface Model : BaseModel<BusInfoItem>
}