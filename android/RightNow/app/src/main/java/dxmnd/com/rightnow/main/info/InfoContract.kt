package dxmnd.com.rightnow.main.info

import android.content.Context
import android.location.Address
import dxmnd.com.rightnow.base.BasePresenter
import dxmnd.com.rightnow.base.BaseView
import dxmnd.com.rightnow.main.info.adapter.model.BusInfoContract

interface InfoContract {
    interface View : BaseView<Presenter> {
        fun mapInit()
    }

    interface Presenter : BasePresenter {
        var adapterContractModel : BusInfoContract.Model?
        var adapterContractView : BusInfoContract.View?

        fun getLocation(context: Context)
    }
}