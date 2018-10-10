package com.wtowto7207.router;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import com.taobao.weex.utils.WXLogUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class RouterModule {
    private Context mContext;
    private static volatile RouterModule instance = null;
    private RouterModule(Context context){
        mContext = context;
    }
    public static RouterModule getInstance(Context context){
        if (instance == null) {
            synchronized (RouterModule.class) {
                if (instance == null) {
                    instance = new RouterModule(context);
                }
            }
        }

        return instance;
    }
    /**
     * 根据IP地址获取MAC地址
     *
     *
     */
    public void getLocalMacAddressFromIp(ModuleResultListener listener) {
        String strMacAddr = null;
        try {
            //获得IpD地址
            InetAddress ip = getLocalInetAddress();
            byte[] b = NetworkInterface.getByInetAddress(ip).getHardwareAddress();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                if (i != 0) {
                    buffer.append(':');
                }
                String str = Integer.toHexString(b[i] & 0xFF);
                buffer.append(str.length() == 1 ? 0 + str : str);
            }
            strMacAddr = buffer.toString().toUpperCase();
        } catch (Exception e) {
            WXLogUtils.e(e.toString());
        }

        listener.onResult(strMacAddr);
    }

    /**
     * 获取移动设备本地IP
     *
     *
     */
    private static InetAddress getLocalInetAddress() {
        InetAddress ip = null;
        try {
            //列举
            Enumeration<NetworkInterface> en_netInterface = NetworkInterface.getNetworkInterfaces();
            while (en_netInterface.hasMoreElements()) {//是否还有元素
                NetworkInterface ni = (NetworkInterface) en_netInterface.nextElement();//得到下一个元素
                Enumeration<InetAddress> en_ip = ni.getInetAddresses();//得到一个ip地址的列举
                while (en_ip.hasMoreElements()) {
                    ip = en_ip.nextElement();
                    if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1)
                        break;
                    else
                        ip = null;
                }

                if (ip != null) {
                    break;
                }
            }
        } catch (SocketException e) {

            e.printStackTrace();
        }
        return ip;
    }

    /**
     * 获取手机的Ip地址
     */
    public void getIpAddress(ModuleResultListener listener) {
        String IpAddress = getLocalInetAddress().toString().substring(1);
        listener.onResult(IpAddress);
    }

    /**
     * 获取WifiInfo
     */
    public static WifiInfo getWifiInfo(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = null;
        if (null != wifiManager) {
            info = wifiManager.getConnectionInfo();
        }
        return info;
    }


    public static long ipAddressToint(String ip) {
        String[] items = ip.split("\\.");
        return Long.valueOf(items[0]) << 24
            | Long.valueOf(items[1]) << 16
            | Long.valueOf(items[2]) << 8
            | Long.valueOf(items[3]);
    }

    public static String intToIpAddress(long ipInt) {
        StringBuffer sb = new StringBuffer();
        sb.append(ipInt & 0xFF).append(".");
        sb.append((ipInt >> 8) & 0xFF).append(".");
        sb.append((ipInt >> 16) & 0xFF).append(".");
        sb.append((ipInt >> 24) & 0xFF);
        return sb.toString();
    }

    /**
     * 获取当前可连接Wifi列表
     * 暂不支持7.0及以上系统
     */
    public void getAvailableNetworks(ModuleResultListener listener) {
        WifiManager wifiManager = (WifiManager) mContext.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> wifiList = null;
        if (wifiManager != null) {
            wifiList = wifiManager.getScanResults();
        }
        listener.onResult(wifiList);
    }

    /**
     * 获取已连接的Wifi路由器的Mac地址
     * 暂不支持7.0及以上系统
     */
    public void getConnectedWifiMacAddress(ModuleResultListener listener) {
        String connectedWifiMacAddress = null;
        WifiManager wifiManager = (WifiManager) mContext.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> wifiList;

        if (wifiManager != null) {
            wifiList = wifiManager.getScanResults();
            WifiInfo info = wifiManager.getConnectionInfo();
            if (wifiList != null && info != null) {
                for (int i = 0; i < wifiList.size(); i++) {
                    ScanResult result = wifiList.get(i);
                    if (info.getBSSID().equals(result.BSSID)) {
                        connectedWifiMacAddress = result.BSSID;
                    }
                }
            }
        }
        listener.onResult(connectedWifiMacAddress);
    }
}
