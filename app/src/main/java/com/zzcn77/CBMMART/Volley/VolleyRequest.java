package com.zzcn77.CBMMART.Volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.zzcn77.CBMMART.App;

import java.util.Map;

/**
 * Created by 赵磊 on 2017/7/12.
 */

public class VolleyRequest {
    public static StringRequest request;
    private Context context;

    public static void RequestGet(Context context, String url, String tag, VolleyInterface vif) {
        App.getQueues().cancelAll(tag);
        request = new StringRequest(Request.Method.GET, url, vif.loadingListener(), vif.errorListener());
        request.setTag(tag);
        App.getQueues().add(request);
    }

    public static void RequestPost(Context context, String url, String tag, final Map<String, String> params, VolleyInterface vif) {
        App.getQueues().cancelAll(tag);
        request = new StringRequest(Request.Method.POST, url, vif.loadingListener(), vif.errorListener()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        request.setTag(tag);
        App.getQueues().add(request);
    }
}