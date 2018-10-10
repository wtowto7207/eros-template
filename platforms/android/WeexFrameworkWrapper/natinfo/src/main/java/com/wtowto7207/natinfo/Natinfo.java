package com.wtowto7207.natinfo;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.instapp.nat.device.info.InfoModule;
import com.instapp.nat.device.info.ModuleResultListener;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */
@WeexModule(name = "nat/device/info")
public class Natinfo extends WXModule{

    @JSMethod
    public void info(final JSCallback jsCallback){
        InfoModule.getInstance(mWXSDKInstance.getContext()).info(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
