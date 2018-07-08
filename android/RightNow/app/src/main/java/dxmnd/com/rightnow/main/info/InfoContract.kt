package dxmnd.com.rightnow.main.info

import dxmnd.com.rightnow.base.BasePresenter
import dxmnd.com.rightnow.base.BaseView
import dxmnd.com.rightnow.main.info.adapter.model.BusInfoContract

interface InfoContract {
    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter {
        var adapterContractModel : BusInfoContract.Model?
        var adapterContractView : BusInfoContract.View?
    }
}