package com.nik.igurucode.apicall;



import com.nik.igurucode.model.Root;

import java.util.List;

import retrofit2.Call;


public interface iResponseCallback<T> {
    void success(T data);

    void onFailure(Root rootsData);

    void onError(Call<T> responseCall, Throwable T);
}
