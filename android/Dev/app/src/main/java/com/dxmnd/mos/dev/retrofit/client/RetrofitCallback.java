package com.dxmnd.mos.dev.retrofit.client;

public interface RetrofitCallback<T> {
    void onError(Throwable t);

    void onSuccess(int code, T receivedData);

    void onFailure(int code);
}
