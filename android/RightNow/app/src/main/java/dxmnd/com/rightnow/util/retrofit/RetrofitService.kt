package dxmnd.com.rightnow.util.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.util.*

interface RetrofitService {
    @GET("/")
    fun getBusRoute(@QueryMap map : Map<String, String>) : Observable
}