package com.wtowto7207.natalipay;

import android.app.Activity;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import com.instapp.nat.alipay.AlipayModule;
import com.instapp.nat.alipay.ModuleResultListener;

import java.util.HashMap;

/**
 * Created by Acathur on 17/10/1.
 *  Copyright (c) 2017 Instapp. All rights reserved.
 */
@WeexModule(name = "nat/alipay")
public class alipay extends WXModule {
    @JSMethod
    public void pay(HashMap<String, Object> params, final JSCallback jsCallback){
        AlipayModule.getInstance(mWXSDKInstance.getContext()).pay((Activity) mWXSDKInstance.getContext(), params, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void auth(HashMap<String, Object> params, final JSCallback jsCallback){
        AlipayModule.getInstance(mWXSDKInstance.getContext()).auth((Activity) mWXSDKInstance.getContext(), params, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
