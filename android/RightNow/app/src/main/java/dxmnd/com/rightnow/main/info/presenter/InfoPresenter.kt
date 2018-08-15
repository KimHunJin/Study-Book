package dxmnd.com.rightnow.main.info.presenter

import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import com.google.android.gms.location.LocationRequest
import com.patloew.rxlocation.RxLocation
import dxmnd.com.rightnow.main.info.InfoContract
import dxmnd.com.rightnow.main.info.adapter.model.BusInfoContract

class InfoPresenter(infoView: InfoContract.View) : InfoContract.Presenter {

    override var adapterContractModel: BusInfoContract.Model? = null
    override var adapterContractView: BusInfoContract.View? = null

    init {
        infoView.presenter = this
    }

    var currentLocation: Address? = null

    @SuppressLint("MissingPermission")
    override fun getLocation(context: Context) {
        var locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)

        var rxLocation = RxLocation(context)

        rxLocation.location().updates(locationRequest)
                .flatMap { location -> rxLocation.geocoding().fromLocation(location).toObservable() }
                .subscribe { address -> setLocation(address) }

    }

    private fun setLocation(address: Address) {
        currentLocation = address
    }

    fun getLocation(): Address {
        return currentLocation!!
    }
}