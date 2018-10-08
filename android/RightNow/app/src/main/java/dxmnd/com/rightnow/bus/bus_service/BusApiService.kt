package dxmnd.com.rightnow.bus.bus_service

import dxmnd.com.rightnow.bus.service_model.RequestModel
import dxmnd.com.rightnow.bus.service_model.ResponseModel
import dxmnd.com.rightnow.service.repo.RetrofitService
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class BusApiService(retrofit:Retrofit) {


    private val api = retrofit.create(RetrofitService::class.java)

    fun getBusList(request :RequestModel) :Maybe<ResponseModel>{
        return api.getBusList(request.getNumber())
    }
}