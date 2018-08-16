package com.dxmnd.mos.dev.retrofit.client;

import android.content.Context;

import com.dxmnd.mos.dev.retrofit.model.ResponseModel;
import com.dxmnd.mos.dev.retrofit.service.RetrofitService;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient extends RxAppCompatActivity{

    private static final String BASE_URL = "";
    private static Retrofit retrofit = null;

    private static Context mContext;
    private RetrofitService service;

    private static class Singleton {
        private static RetrofitClient newInstance = new RetrofitClient(mContext);
    }

    public static RetrofitClient getInstance(Context context) {
        if(context != null) {
            mContext = context;
        }
        return Singleton.newInstance;
    }

    private RetrofitClient(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public RetrofitClient createBaseApi() {
        service = create(RetrofitService.class);
        return this;
    }

    public  <T> T create(final Class<T> service) {
        if (service == null) {
            throw new RuntimeException("Api service is null!");
        }
        return retrofit.create(service);
    }

    public void login(final HashMap<String, String> params, final RetrofitCallback callback){
//        service.login(params)
        // todo rxjava
        Observable<List<ResponseModel>> loginObserver = createBaseApi().service.login(params);
        loginObserver.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<List<ResponseModel>>bindToLifecycle())
                .subscribe(data -> {
                        callback.onSuccess(200,data);
                        }, e -> callback.onError()
                );
    }
}
