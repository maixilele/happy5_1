package com.example.happy5_1.mvp.presenter;

import com.example.happy5_1.entity.GouEntity;
import com.example.happy5_1.mvp.Contract.GouContract;
import com.example.lib_core.mvp.presenter.BasePresenter;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GouPresenter extends BasePresenter<GouContract.Model,GouContract.View> {
    public GouPresenter(GouContract.Model mModel, GouContract.View mView) {
        super(mModel, mView);
    }

    public void getModel(){
        mModel.getGou()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<GouEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ArrayList<GouEntity> gouEntity) {
                        if (gouEntity!=null){
                            mView.initAdapter(gouEntity);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
