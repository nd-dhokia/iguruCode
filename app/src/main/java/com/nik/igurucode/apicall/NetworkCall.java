package com.nik.igurucode.apicall;

import com.nik.igurucode.model.Article;
import com.nik.igurucode.model.Root;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall implements iApiMethodList{

    private static NetworkCall instance = new NetworkCall();
    private iApiService apiService;

    private NetworkCall() {
        apiService = RetroClient.getApiService();
    }

    public static NetworkCall getInstance() {
        return instance;
    }

    @Override
    public void callFreeNewsDataApi(HashMap<String, String> param, iResponseCallback<Root> callback) {
        Call<Root> call = apiService.callFreeNewsDataApi(param);
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                Root baseModel = response.body();
                if (response.isSuccessful()) {
                    callback.success(response.body());
                } else {
                    callback.onFailure(baseModel);
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                callback.onError(call, t);
            }
        });
    }
}
