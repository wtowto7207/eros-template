package com.wtowto7207.natstream;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.instapp.nat.stream.ModuleResultListener;
import com.instapp.nat.stream.StreamModule;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */
@WeexModule(name = "nat/stream")
public class Natstream extends WXModule {

    @JSMethod
    public void fetch(String str, final JSCallback jsCallback){
        StreamModule.getInstance(mWXSDKInstance.getContext()).fetch(str, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
