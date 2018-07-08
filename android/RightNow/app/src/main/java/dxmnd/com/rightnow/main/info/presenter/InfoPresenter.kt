package dxmnd.com.rightnow.main.info.presenter

import dxmnd.com.rightnow.main.info.InfoContract
import dxmnd.com.rightnow.main.info.adapter.model.BusInfoContract

class InfoPresenter(infoView : InfoContract.View) : InfoContract.Presenter {
    override var adapterContractModel: BusInfoContract.Model? = null
    override var adapterContractView: BusInfoContract.View? = null

    init {
        infoView.presenter = this
    }

}