package dxmnd.com.rightnow.util.retrofit

import dxmnd.com.rightnow.util.GET_STAIONS_BY_ROUTE_LIST
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.util.*

interface RetrofitService {
    @GET(GET_STAIONS_BY_ROUTE_LIST)
    fun getBusRoute(@QueryMap map : Map<String, String>) : Observable
}