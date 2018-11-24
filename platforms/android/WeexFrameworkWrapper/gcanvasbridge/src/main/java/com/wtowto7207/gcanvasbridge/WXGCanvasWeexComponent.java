package com.wtowto7207.gcanvasbridge;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.TextureView;

import com.alibaba.weex.plugin.annotation.WeexComponent;
import com.taobao.gcanvas.GCanvasJNI;
import com.taobao.gcanvas.bridges.spec.module.IGBridgeModule;
import com.taobao.gcanvas.surface.GTextureView;
import com.taobao.gcanvas.util.GLog;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.dom.WXDomObject;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author ertong
 */

@WeexComponent(names = "gcanvas")
@Component(lazyload = false)
public class WXGCanvasWeexComponent extends WXComponent<GWXTextureView> implements TextureView.SurfaceTextureListener {
    private GWXTextureView mSurfaceView;
    private AtomicBoolean mSended = new AtomicBoolean(false);
    public IGBridgeModule.ContextType mType;

    private static final String TAG = WXGCanvasWeexComponent.class.getSimpleName();

    private void addGCanvasView() {
        String backgroundColor = getDomObject().getStyles().getBackgroundColor();
        mSurfaceView = new GWXTextureView(getContext(), this);
        GCanvasJNI.registerWXCallNativeFunc(getContext());
        if (backgroundColor.isEmpty()) {
            backgroundColor = "rgba(0,0,0,0)";
        }
        mSurfaceView.setBackgroundColor(backgroundColor);
        mSurfaceView.addSurfaceTextureListener(this);
    }

    public static class Creator implements ComponentCreator {
        public WXComponent createInstance(WXSDKInstance instance, WXDomObject node, WXVContainer parent, boolean lazy) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new WXGCanvasWeexComponent(instance, node, parent, lazy);
        }

        public WXComponent createInstance(WXSDKInstance instance, WXDomObject node, WXVContainer parent) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new WXGCanvasWeexComponent(instance, node, parent);
        }
    }

    @Deprecated
    public WXGCanvasWeexComponent(WXSDKInstance instance, WXDomObject dom, WXVContainer parent, String instanceId, boolean isLazy) {
        this(instance, dom, parent, isLazy);
    }

    public WXGCanvasWeexComponent(WXSDKInstance instance, WXDomObject node,
                                  WXVContainer parent, boolean lazy) {
        super(instance, node, parent, lazy);
    }

    public WXGCanvasWeexComponent(WXSDKInstance instance, WXDomObject node,
                                  WXVContainer parent) {
        super(instance, node, parent);
    }

    @Override
    public void onActivityResume() {
        if (null != mSurfaceView) {
            mSurfaceView.resume();
        }
    }

    @Override
    public void onActivityDestroy() {
        if (null != mSurfaceView) {
            mSurfaceView.setSurfaceTextureListener(null);
            mSurfaceView.requestExit();
        }
    }

    @Override
    public void onActivityPause() {
        if (null != mSurfaceView) {
            mSurfaceView.pause();
        }
    }

    @Override
    protected GWXTextureView initComponentHostView(@NonNull Context context) {
        mSended.set(false);
        addGCanvasView();

        return mSurfaceView;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {

    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Context ctx = getContext();
        if (ctx == null) {
            GLog.e(TAG, "setDevicePixelRatio error ctx == null");
            return;
        }

        Display display = ((Activity) ctx).getWindowManager().getDefaultDisplay();

        int screenWidth = display.getWidth();
        double devicePixelRatio = screenWidth / 750.0;

        GLog.d(TAG, "enable width = " + screenWidth + ",devicePixelRatio = " + devicePixelRatio);

        GCanvasJNI.setDevicePixelRatio(getRef(), devicePixelRatio);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }

    public GTextureView getSurfaceView() {
        return mSurfaceView;
    }

    public void sendEvent() {

        synchronized (this) {
            if (!mSended.get()) {
                Map<String, Object> params = new HashMap<>();
                params.put("ref", getRef());

                getInstance().fireGlobalEventCallback("GCanvasReady", params);
                mSended.set(true);
            } else {
                GLog.d("event sent.");
            }
        }
    }
}
