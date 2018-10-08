package com.dxmnd.mos.mvvm.service

import com.dxmnd.mos.mvvm.utils.GET_BUS_LIST
import io.reactivex.Observable
import retrofit2.http.GET

interface ServiceAPI {
    @GET(GET_BUS_LIST)
    fun getBusList(): Observable<List<ServiceModel>>
}