package com.eros.wx;

import android.app.Application;

import com.alibaba.weex.plugin.annotation.WeexComponent;
import com.alibaba.weex.plugin.annotation.WeexModule;
import com.eros.framework.BMWXApplication;

/**
 * Created by Carry on 2017/8/23.
 */
@WeexComponent(names = "gcanvas")
@WeexModule(name = "gcanvas")
public class App extends BMWXApplication {
    public Application mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;


    }

}
