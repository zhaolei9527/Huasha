package com.zzcn77.CBMMART.Activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.zzcn77.CBMMART.App;
import com.zzcn77.CBMMART.Base.BaseActivity;
import com.zzcn77.CBMMART.Bean.LoginBean;
import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.Utils.EasyToast;
import com.zzcn77.CBMMART.Utils.SPUtil;
import com.zzcn77.CBMMART.Utils.UrlUtils;
import com.zzcn77.CBMMART.Utils.Utils;
import com.zzcn77.CBMMART.Volley.VolleyInterface;
import com.zzcn77.CBMMART.Volley.VolleyRequest;

import java.util.HashMap;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * Created by 赵磊 on 2017/7/13.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    Button btnLogin;
    @Override
    protected int setthislayout() {
        return R.layout.login_layout;
    }
    @Override
    protected void initview() {
        btnLogin = (Button) findViewById(R.id.btn_login);
    }
    @Override
    protected void initListener() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent();
        intent.setAction("LoginActivityIsStart");
        sendBroadcast(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        App.queues.cancelAll("login");
    }

    private void toLogin(String email, final String passworld) {
        HashMap<String, String> params = new HashMap<>();
        params.put("key", UrlUtils.key);
        params.put("username", email);
        params.put("password", passworld);
        VolleyRequest.RequestPost(context, UrlUtils.BaseUrl + "login", "login", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = Utils.decode(result);
                if (decode.isEmpty()) {
                    EasyToast.showShort(context, getString(R.string.Networkexception));
                } else {
                    LoginBean loginBean = new Gson().fromJson(decode, LoginBean.class);
                    if (loginBean.getStu().equals("1")) {
                        if (loginBean.getMsg().contains("登陆成功")) {
                            JPushInterface.setAlias(getApplicationContext(), loginBean.getRes().getId(), new TagAliasCallback() {
                                @Override
                                public void gotResult(int i, String s, Set<String> set) {
                                    Log.d("LoginActivity", "Alias" + s);
                                }
                            });
                            Toast.makeText(context, R.string.welcomeback, Toast.LENGTH_SHORT).show();
                            SPUtil.putAndApply(context, "email", loginBean.getRes().getEmail());
                            SPUtil.putAndApply(context, "password", passworld);
                            SPUtil.putAndApply(context, "id", loginBean.getRes().getId());
                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    gotoMain();
                                }
                            }, 1000);
                        }
                    } else {
                        if (loginBean.getMsg().contains("您已被封号")) {
                            Toast.makeText(context, getString(R.string.akick), Toast.LENGTH_LONG).show();
                        } else if (loginBean.getMsg().contains("密码有误")) {
                            Toast.makeText(context, getString(R.string.usernameorpassworderror), Toast.LENGTH_LONG).show();
                        } else if (loginBean.getMsg().contains("用户名不存在")) {
                            Toast.makeText(context, getString(R.string.Usernamedoesnotexist), Toast.LENGTH_LONG).show();
                        } else {
                            EasyToast.showShort(context, getString(R.string.Abnormalserver));
                        }
                    }
                }
            }
            @Override
            public void onMyError(VolleyError error) {
            }
        });
    }

    private void gotoMain() {
        startActivity(new Intent(context, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                boolean connected = Utils.isConnected(context);
                if (connected) {
                    toLogin("975976959@qq.com", "123456");
                } else {
                    if (context != null) {
                        EasyToast.showShort(context, getString(R.string.Notconnect));
                    }
                }
                break;
        }
    }
}
