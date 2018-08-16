package dxmnd.com.rightnow.main.info.presenter

import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import com.google.android.gms.location.LocationRequest
import com.patloew.rxlocation.RxLocation
import dxmnd.com.rightnow.main.info.InfoContract
import dxmnd.com.rightnow.main.info.adapter.model.BusInfoContract
import io.reactivex.disposables.Disposable

class InfoPresenter(infoView: InfoContract.View) : InfoContract.Presenter {

    override var adapterContractModel: BusInfoContract.Model? = null
    override var adapterContractView: BusInfoContract.View? = null

    init {
        infoView.presenter = this
    }

    var currentLocation: Address? = null

    @SuppressLint("MissingPermission")
    override fun getLocation(context: Context): Disposable? {
        val locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)

        val rxLocation = RxLocation(context)

        return rxLocation.location().updates(locationRequest)
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