package com.zzcn77.CBMMART.Activity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.zzcn77.CBMMART.App;
import com.zzcn77.CBMMART.Base.BaseActivity;
import com.zzcn77.CBMMART.Bean.EmailCodeBean;
import com.zzcn77.CBMMART.Bean.FindPWDBean;
import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.Utils.EasyToast;
import com.zzcn77.CBMMART.Utils.UrlUtils;
import com.zzcn77.CBMMART.Utils.Utils;
import com.zzcn77.CBMMART.Volley.VolleyInterface;
import com.zzcn77.CBMMART.Volley.VolleyRequest;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 赵磊 on 2017/7/15.
 */

public class ForgetActivity extends BaseActivity implements View.OnClickListener {
    private EditText etEmail;
    private EditText etCaptcha;
    private EditText etPassword;
    private EditText etPasswordAgain;
    private Button btnOk;
    private Button btnGet;
    private LinearLayout ll_login;
    boolean noterror = true;
    private int time;
    Timer timer;
    private TimerTask task;
    private boolean connected;

    @Override
    protected int setthislayout() {
        return R.layout.forget_layout;
    }

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
    protected void initview() {
        etCaptcha = (EditText) findViewById(R.id.et_captcha);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        etPasswordAgain = (EditText) findViewById(R.id.et_password_again);
        btnGet = (Button) findViewById(R.id.btn_get);
        btnOk = (Button) findViewById(R.id.btn_ok);
        ll_login = (LinearLayout) findViewById(R.id.ll_login);
    }

    @Override
    protected void initListener() {
        btnGet.setOnClickListener(this);
        btnOk.setOnClickListener(this);
        ll_login.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_get:
                connected = Utils.isConnected(context);
                if (connected) {
                    getcaptcha();
                } else {
                    if (context != null) {
                        EasyToast.showShort(context, getString(R.string.Notconnect));
                    }
                }
                break;
            case R.id.btn_ok:
                connected = Utils.isConnected(context);
                if (connected) {
                    toreset();
                } else {
                    if (context != null) {
                        EasyToast.showShort(context, getString(R.string.Notconnect));
                    }
                }
                break;
            case R.id.ll_login:
                finish();
                break;
        }
    }

    private void toreset() {

        if (etEmail.getText().toString().trim().isEmpty()) {
            EasyToast.showShort(context, getResources().getString(R.string.emailisEmpty));
            return;
        }

        if (!etEmail.getText().toString().trim().matches("^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$")) {
            EasyToast.showShort(context, getResources().getString(R.string.emailisnotregx));
            return;
        }

        if (etCaptcha.getText().toString().trim().isEmpty()) {
            EasyToast.showShort(context, getResources().getString(R.string.CaptchaisEmpty));
            return;
        }

        if (etPassword.getText().toString().trim().isEmpty()) {
            EasyToast.showShort(context, getResources().getString(R.string.password));
            return;
        }

        if (etPassword.getText().toString().length() < 6) {
            EasyToast.showShort(context, getResources().getString(R.string.passwordistolow));
            return;
        }

        if (etPasswordAgain.getText().toString().trim().isEmpty()) {
            EasyToast.showShort(context, getResources().getString(R.string.passwordagain));
            return;
        }

        if (!etPassword.getText().toString().trim().equals(etPasswordAgain.getText().toString().trim())) {
            EasyToast.showShort(context, getResources().getString(R.string.passwordisinconformity));
            return;
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("key", UrlUtils.key);
        params.put("email", etEmail.getText().toString().trim());
        params.put("ecode", etCaptcha.getText().toString().trim());
        params.put("password", etPassword.getText().toString().trim());

        VolleyRequest.RequestPost(context, UrlUtils.BaseUrl + "findpwd", "findpwd", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = Utils.decode(result);
                if (decode.isEmpty()) {
                    EasyToast.showShort(context, getString(R.string.Networkexception));
                } else {
                    FindPWDBean FindPWDBean = new Gson().fromJson(decode, FindPWDBean.class);
                    if (FindPWDBean.getStu().equals("1")) {
                        if (FindPWDBean.getMsg().contains("密码找回成功")) {
                            Toast.makeText(context, R.string.passwordchangeok, Toast.LENGTH_LONG).show();
                            finish();
                        }
                    } else {
                        if (FindPWDBean.getMsg().contains("邮箱不存在")) {
                            EasyToast.showShort(context, getString(R.string.Usernamedoesnotexist));
                        } else if (FindPWDBean.getMsg().contains("该邮箱验证码已失效或与邮箱不匹配")) {
                            EasyToast.showShort(context, "The email verification code has been failure or and email don't match");
                        } else if (FindPWDBean.getMsg().contains("邮箱验证码输入有误")) {
                            EasyToast.showShort(context, "Email verification code input is wrong");
                        } else if (FindPWDBean.getMsg().contains("找回失败，请稍候操作")) {
                            EasyToast.showShort(context, "Find failure, please wait");
                        } else {
                            EasyToast.showShort(context, getString(R.string.Abnormalserver));
                        }
                    }
                }

            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                EasyToast.showShort(context, getString(R.string.hasError));
            }
        });
    }

    private void getcaptcha() {
        time = 60;
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {      // UI thread
                    @Override
                    public void run() {
                        time--;
                        btnGet.setText("" + time);
                        if (time < 0) {
                            timer.cancel();
                            btnGet.setText(getString(R.string.get));
                            btnGet.setEnabled(true);
                        }
                    }
                });
            }
        };
        timer.schedule(task, 1000, 1000);       // timeTask
        if (etEmail.getText().toString().trim().isEmpty()) {
            EasyToast.showShort(context, getResources().getString(R.string.emailisEmpty));
            return;
        }
        if (!etEmail.getText().toString().trim().matches("^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$")) {
            EasyToast.showShort(context, getResources().getString(R.string.emailisnotregx));
            return;
        }

        noterror = true;
        HashMap<String, String> params = new HashMap<>();
        params.put("key", UrlUtils.key);
        params.put("email", etEmail.getText().toString().trim());
        VolleyRequest.RequestPost(context, UrlUtils.BaseUrl + "emailcode", "emailcode", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = Utils.decode(result);
                if (decode.isEmpty()) {
                    EasyToast.showShort(context, getString(R.string.Networkexception));
                } else {
                    EmailCodeBean emailCodeBean = new Gson().fromJson(decode, EmailCodeBean.class);
                    if (emailCodeBean.getStu().equals("1")) {
                        if (emailCodeBean.getMsg().contains("发送成功")) {
                            Toast.makeText(context, R.string.sendsuccessfully, Toast.LENGTH_LONG).show();
                        }
                    } else {
                        if (emailCodeBean.getMsg().contains("发送失败,请稍后再试")) {
                            Toast.makeText(context, R.string.sendfailure, Toast.LENGTH_LONG).show();
                        } else if (emailCodeBean.getMsg().contains("该邮箱还没有注册")) {
                            Toast.makeText(context, R.string.emailnotregistered, Toast.LENGTH_LONG).show();
                        } else if (emailCodeBean.getMsg().contains("1分钟只能发送一次")) {
                            Toast.makeText(context, R.string.codesendonce, Toast.LENGTH_LONG).show();
                        } else {
                            EasyToast.showShort(context, getString(R.string.Abnormalserver));
                        }
                    }
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                if (btnGet != null) {
                    timer.cancel();
                    btnGet.setText(getString(R.string.get));
                    btnGet.setEnabled(true);
                }
                error.printStackTrace();
                EasyToast.showShort(context, getString(R.string.hasError));
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        App.queues.cancelAll("emailcode");
        App.queues.cancelAll("findpwd");
    }
}
