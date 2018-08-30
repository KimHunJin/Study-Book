package dxmnd.com.rightnow.util

import android.annotation.SuppressLint
import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.NonNull
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.location.LocationRequest
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.patloew.rxlocation.RxLocation

fun log(any : Any) {
    Logger.addLogAdapter(AndroidLogAdapter())

    when (any) {
        is Throwable -> Logger.e(any.message.toString())
        else -> Logger.d(any.toString())
    }
}

@SuppressLint("MissingPermission")
fun checkLocation(context: Context) {
    val rxLocation = RxLocation(context)

    val locationRequest = LocationRequest.create()
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
            .setInterval(5000)

    rxLocation.location().updates(locationRequest)
            .flatMap { location -> rxLocation.geocoding().fromLocation(location).toObservable() }
            .subscribe { address ->
                Toast.makeText(context,
                        address.latitude.toString() + " " + address.longitude.toString(),
                        Toast.LENGTH_SHORT).show()
            }
}
