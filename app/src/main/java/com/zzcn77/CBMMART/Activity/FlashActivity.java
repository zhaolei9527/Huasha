package com.zzcn77.CBMMART.Activity;

import android.content.Intent;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
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

/**
 * Created by 赵磊 on 2017/7/13.
 */

public class FlashActivity extends BaseActivity {
    @Override
    protected void ready() {
        super.ready();
       /*set it to be no title*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       /*set it to be full screen*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected int setthislayout() {
        return R.layout.flash_layout;
    }

    @Override
    protected void initview() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        boolean connected = Utils.isConnected(context);
        if (connected) {
            AutoLogin();
        } else {
            if (context != null) {
                EasyToast.showShort(context, getString(R.string.Notconnect));
                startActivity(new Intent(context, LoginActivity.class));
                finish();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        App.queues.cancelAll("login");
    }

    private void AutoLogin() {
        String account = (String) SPUtil.get(context, "email", "");
        String password = (String) SPUtil.get(context, "password", "");
        if (account.trim().isEmpty() || password.trim().isEmpty()) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(context, LoginActivity.class));
                    finish();
                }
            }, 1500);

        } else {
            HashMap<String, String> params = new HashMap<>();
            params.put("key", UrlUtils.key);
            params.put("username", String.valueOf(SPUtil.get(context, "email", "")));
            params.put("password", String.valueOf(SPUtil.get(context, "password", "")));
            VolleyRequest.RequestPost(context, UrlUtils.BaseUrl + "login", "login", params, new VolleyInterface(context) {
                @Override
                public void onMySuccess(String result) {
                    String decode = Utils.decode(result);
                    Log.d("FlashActivity", decode);

                    if (decode.isEmpty()) {
                        EasyToast.showShort(context, getString(R.string.Networkexception));
                    } else {
                        LoginBean loginBean = new Gson().fromJson(decode, LoginBean.class);
                        if (loginBean.getStu().equals("1")) {
                            // TODO: 2017/5/19 注册
                            if (loginBean.getMsg().contains("登陆成功")) {
                                Toast.makeText(context, R.string.welcomeback, Toast.LENGTH_SHORT).show();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        startActivity(new Intent(context, ForgetActivity.class));
                                        finish();
                                    }
                                }, 1000);
                            }
                        } else {
                            if (loginBean.getMsg().contains("您已被封号")) {
                                Toast.makeText(context, getString(R.string.akick), Toast.LENGTH_LONG).show();
                                gotoMain();
                            } else if (loginBean.getMsg().contains("密码有误")) {
                                Toast.makeText(context, getString(R.string.usernameorpassworderror), Toast.LENGTH_LONG).show();
                                gotoMain();
                            } else if (loginBean.getMsg().contains("用户名不存在")) {
                                Toast.makeText(context, getString(R.string.Usernamedoesnotexist), Toast.LENGTH_LONG).show();
                                gotoMain();
                            } else {
                                EasyToast.showShort(context, getString(R.string.Abnormalserver));
                                gotoMain();
                            }
                        }
                    }
                }
                @Override
                public void onMyError(VolleyError error) {
                    error.printStackTrace();
                    EasyToast.showShort(context, getString(R.string.hasError));
                    gotoMain();
                }
            });
        }
    }

    private void gotoMain() {
        startActivity(new Intent(context, LoginActivity.class));
        finish();
    }
}
