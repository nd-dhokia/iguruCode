package com.nik.igurucode.apicall;

import com.nik.igurucode.model.Article;
import com.nik.igurucode.model.Root;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface iApiService {

    //get Restaurant list
    @GET(ApiParam.CHILD_URL)
    Call<Root> callFreeNewsDataApi(@QueryMap HashMap<String, String> map);
}
