package com.wtowto7207.natvibration;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.instapp.nat.device.vibration.VibrationModule;
import com.instapp.nat.device.vibration.ModuleResultListener;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */
@WeexModule(name = "nat/device/vibration")
public class Natvibration extends WXModule{

    @JSMethod
    public void vibrate(int time, final JSCallback jsCallback){
        VibrationModule.getInstance(mWXSDKInstance.getContext()).vibrate(time, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
