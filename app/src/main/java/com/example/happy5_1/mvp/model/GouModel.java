package com.example.happy5_1.mvp.model;

import com.example.happy5_1.entity.GouEntity;
import com.example.happy5_1.mvp.Contract.GouContract;
import com.example.happy5_1.mvp.api.GouApi;
import com.example.lib_core.http.RetrofitHttp;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GouModel implements GouContract.Model {

    @Override
    public Observable<ArrayList<GouEntity>> getGou() {
        return RetrofitHttp.getRetrofit().create(GouApi.class).getGou();
    }

    @Override
    public void destroy() {

    }
}
