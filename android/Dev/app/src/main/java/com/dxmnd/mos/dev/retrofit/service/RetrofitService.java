package com.dxmnd.mos.dev.retrofit.service;

import com.dxmnd.mos.dev.retrofit.model.ResponseModel;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.POST;

public interface RetrofitService {
    @POST("/")
    Observable<List<ResponseModel>> login(@FieldMap HashMap<String, String> map);
}
