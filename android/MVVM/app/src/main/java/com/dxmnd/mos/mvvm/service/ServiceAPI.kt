package com.dxmnd.mos.mvvm.service

import com.dxmnd.mos.mvvm.utils.GET_BUS_ARRIVE_INFO
import com.dxmnd.mos.mvvm.utils.GET_BUS_LIST
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI {
    @GET(GET_BUS_LIST)
    fun getBusList(@Query("number") number:String): Observable<List<ServiceModel.BusListModel>>

    @GET(GET_BUS_ARRIVE_INFO)
    fun getBUsArriveList(@Query("busNumber") number:String, @Query("busStation") station:String) : Observable<List<ServiceModel.BusArriveInfoModel>>

}