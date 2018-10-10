package com.wtowto7207.natvolume;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.instapp.nat.device.volume.VolumeModule;
import com.instapp.nat.device.volume.ModuleResultListener;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */
@WeexModule(name = "nat/device/volume")
public class Natvolume extends WXModule {

    @JSMethod
    public void get(final JSCallback jsCallback){
        VolumeModule.getInstance(mWXSDKInstance.getContext()).get(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void set(float volume, final JSCallback jsCallback){
        VolumeModule.getInstance(mWXSDKInstance.getContext()).set(volume, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}

