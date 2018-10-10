package com.wtowto7207.natbattery;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.instapp.nat.device.battery.BatteryModule;
import com.instapp.nat.device.battery.ModuleResultListener;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */
@WeexModule(name = "nat/device/battery")
public class Natbattery extends WXModule{

    @JSMethod
    public void status(final JSCallback jsCallback){
        BatteryModule.getInstance(mWXSDKInstance.getContext()).status(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
