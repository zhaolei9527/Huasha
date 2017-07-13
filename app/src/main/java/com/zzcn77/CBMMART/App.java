package com.zzcn77.CBMMART;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by 赵磊 on 2017/7/12.
 */

public class App extends Application {
    /**
     * 先创建一个请求队列，因为这个队列是全局的，所以在Application中声明这个队列
     */
    public static RequestQueue queues;
    @Override
    public void onCreate() {
        super.onCreate();
        queues = Volley.newRequestQueue(getApplicationContext());
        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
    }
    public static RequestQueue getQueues() {
        return queues;
    }
}
