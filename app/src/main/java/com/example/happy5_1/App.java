package com.example.happy5_1;

import android.app.Application;

import com.alipay.sdk.app.EnvUtils;

public
class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
    }
}
