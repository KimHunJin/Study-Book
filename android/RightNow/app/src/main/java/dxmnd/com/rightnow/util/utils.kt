package dxmnd.com.rightnow.util

import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.NonNull
import android.support.v7.app.AppCompatActivity
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger


fun log(any : Any) {
    Logger.addLogAdapter(AndroidLogAdapter())

    when (any) {
        is Throwable -> Logger.e(any.message.toString())
        else -> Logger.d(any.toString())
    }
}