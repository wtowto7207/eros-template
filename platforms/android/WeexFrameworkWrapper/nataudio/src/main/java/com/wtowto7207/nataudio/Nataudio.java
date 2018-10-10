package com.wtowto7207.nataudio;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.instapp.nat.media.audio.AudioModule;
import com.instapp.nat.media.audio.ModuleResultListener;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */
@WeexModule(name = "nat/media/audio")
public class Nataudio extends WXModule {

    @JSMethod
    public void play(String path, final JSCallback jsCallback) {
        AudioModule.getInstance().play(path, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void pause(final JSCallback jsCallback) {
        AudioModule.getInstance().pause(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void stop(final JSCallback jsCallback) {
        AudioModule.getInstance().stop(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
