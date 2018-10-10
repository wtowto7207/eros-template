package com.wtowto7207.natnetwork;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.instapp.nat.device.network.NetworkModule;
import com.instapp.nat.device.network.ModuleResultListener;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */
@WeexModule(name = "nat/device/network")
public class Natnetwork extends WXModule{

    @JSMethod
    public void status(final JSCallback jsCallback){
        NetworkModule.getInstance(mWXSDKInstance.getContext()).status(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
