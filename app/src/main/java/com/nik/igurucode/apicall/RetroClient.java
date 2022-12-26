package com.nik.igurucode.apicall;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetroClient {


    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .readTimeout(100, TimeUnit.SECONDS).build();

    private static Retrofit getRetrofitInstance() {

      /*  Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/

        return new Retrofit.Builder()
                .baseUrl(ApiParam.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static iApiService getApiService() {
        return getRetrofitInstance().create(iApiService.class);
    }

}
