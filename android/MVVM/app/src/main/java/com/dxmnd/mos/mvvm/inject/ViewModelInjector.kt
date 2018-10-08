package com.dxmnd.mos.mvvm.inject

import com.dxmnd.mos.mvvm.main.MainListViewModel
import com.dxmnd.mos.mvvm.main.MainViewModel
import com.dxmnd.mos.mvvm.service.ServiceModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ServiceModule::class)])
interface ViewModelInjector {

    fun inject(mainListViewModel: MainListViewModel)

    fun inject(mainViewModel: MainViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun serviceModule(serviceModule:ServiceModule) : Builder
    }
}