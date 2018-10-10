package com.wtowto7207.router;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by aj_wenlan on 2018/5/31.
 */
@WeexModule(name = "routerMac" )
public class Router extends WXModule{
    @JSMethod(uiThread = false)
    public void getMacAddress(final JSCallback jsCallback){
        RouterModule.getInstance(mWXSDKInstance.getContext()).getLocalMacAddressFromIp(new ModuleResultListener(){
            @Override
            public void onResult(Object o){
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod(uiThread = false)
    public void getIpAddress(final JSCallback jsCallback){
        RouterModule.getInstance(mWXSDKInstance.getContext()).getIpAddress(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod(uiThread = false)
    public void getConnectedWifiMacAddress(final JSCallback jsCallback){
        RouterModule.getInstance(mWXSDKInstance.getContext()).getConnectedWifiMacAddress(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod(uiThread = false)
    public void getAvailableNetworks(final JSCallback jsCallback){
        RouterModule.getInstance(mWXSDKInstance.getContext()).getAvailableNetworks(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
