package dxmnd.com.rightnow.service

import dxmnd.com.rightnow.util.API_URL
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient


class RetrofitFactory {
    fun getAdapter(): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(MockInterceptor())
                .build()

        return Retrofit.Builder()
                .baseUrl(API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}


