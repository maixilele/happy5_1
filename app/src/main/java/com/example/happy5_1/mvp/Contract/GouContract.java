package com.example.happy5_1.mvp.Contract;

import com.example.happy5_1.entity.GouEntity;
import com.example.lib_core.mvp.model.IModel;
import com.example.lib_core.mvp.view.IView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public interface GouContract {
    interface View extends IView{
        void initAdapter(ArrayList<GouEntity> gouEntity);
    }
    interface Model extends IModel{
        Observable<ArrayList<GouEntity>> getGou();
    }
}
