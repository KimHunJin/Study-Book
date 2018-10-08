package com.dxmnd.mos.mvvm.base

import android.arch.lifecycle.ViewModel
import com.dxmnd.mos.mvvm.inject.DaggerViewModelInjector
import com.dxmnd.mos.mvvm.main.MainListViewModel
import com.dxmnd.mos.mvvm.inject.ViewModelInjector
import com.dxmnd.mos.mvvm.main.MainViewModel
import com.dxmnd.mos.mvvm.service.ServiceModule

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .serviceModule(ServiceModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when(this) {
            is MainListViewModel -> injector.inject(this)
            is MainViewModel -> injector.inject(this)
        }
    }
}