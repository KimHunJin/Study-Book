package dxmnd.com.rightnow.main.info.presenter

import android.content.Context
import com.patloew.rxlocation.RxLocation
import dxmnd.com.rightnow.main.info.InfoContract
import dxmnd.com.rightnow.main.info.adapter.model.BusInfoContract
import dxmnd.com.rightnow.main.info.view.InfoFragment
import dxmnd.com.rightnow.util.checkLocation

class InfoPresenter(infoView : InfoContract.View) : InfoContract.Presenter {

    override var adapterContractModel: BusInfoContract.Model? = null
    override var adapterContractView: BusInfoContract.View? = null

    init {
        infoView.presenter = this
    }

    override fun getLocation() {

    }
}