package com.nik.igurucode.apicall;

import com.nik.igurucode.model.Article;
import com.nik.igurucode.model.Root;

import java.util.HashMap;
import java.util.List;

public interface iApiMethodList {

    void callFreeNewsDataApi(HashMap<String, String> param, iResponseCallback<Root> callback);
}
