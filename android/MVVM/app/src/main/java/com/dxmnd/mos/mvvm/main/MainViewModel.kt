package com.dxmnd.mos.mvvm.main

import android.arch.lifecycle.MutableLiveData
import com.dxmnd.mos.mvvm.base.BaseViewModel
import com.dxmnd.mos.mvvm.service.ServiceModel


class MainViewModel:BaseViewModel() {
    private val busId = MutableLiveData<String>()
    private val busNumber = MutableLiveData<String>()

    fun bind(serviceModel: ServiceModel){
        busId.value = serviceModel.busRouteId
        busNumber.value = serviceModel.busRouteNm
    }

    fun getBusId() = busId
    fun getBusNumber() = busNumber
}