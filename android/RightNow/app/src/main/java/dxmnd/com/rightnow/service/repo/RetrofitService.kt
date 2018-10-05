package dxmnd.com.rightnow.service.repo

import dxmnd.com.rightnow.util.GET_SEARCH_BUS_LIST
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.*

interface RetrofitService {

    @GET(GET_SEARCH_BUS_LIST)
    fun getBusList(@Header("number") number :String) : Observable
}