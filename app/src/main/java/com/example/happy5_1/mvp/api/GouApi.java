package com.example.happy5_1.mvp.api;

import com.example.happy5_1.entity.GouEntity;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface GouApi {
    @POST("cart/getList")
    Observable<ArrayList<GouEntity>> getGou();
}
