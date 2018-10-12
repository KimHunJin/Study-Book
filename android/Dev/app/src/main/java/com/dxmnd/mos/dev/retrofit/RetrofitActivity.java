package com.dxmnd.mos.dev.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dxmnd.mos.dev.R;
import com.dxmnd.mos.dev.retrofit.client.RetrofitCallback;
import com.dxmnd.mos.dev.retrofit.client.RetrofitClient;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
    }

    private void retrofit() {
        RetrofitClient.getInstance(this);
    }
}
