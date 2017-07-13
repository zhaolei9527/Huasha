package com.zzcn77.CBMMART.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.zzcn77.CBMMART.App;
import com.zzcn77.CBMMART.Base.BaseActivity;
import com.zzcn77.CBMMART.Bean.EditPWD;
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

public class ChangePassWorldActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_change;

    @Override
    protected int setthislayout() {
        return R.layout.changepassworld_layout;
    }

    @Override
    protected void initview() {
        btn_change = (Button) findViewById(R.id.btn_change);
    }

    @Override
    protected void initListener() {
        btn_change.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_change:
                boolean connected = Utils.isConnected(context);
                if (connected) {
                    forget("123456");
                } else {
                    if (context != null) {
                        EasyToast.showShort(context, getString(R.string.Notconnect));
                    }
                }
                break;
        }
    }
    private void gotoMain() {
        startActivity(new Intent(context, LoginActivity.class));
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        App.queues.cancelAll("editpwd");
    }

    private void forget(final String passworld) {
        HashMap<String, String> params = new HashMap<>();
        params.put("key", UrlUtils.key);
        params.put("id", String.valueOf(SPUtil.get(context,"id","")));
        params.put("oldpwd", String.valueOf(SPUtil.get(context,"password","")));
        params.put("newpwd", passworld);
        VolleyRequest.RequestPost(context, UrlUtils.BaseUrl + "editpwd", "editpwd", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = Utils.decode(result);
                if (decode.isEmpty()) {
                    EasyToast.showShort(context, getString(R.string.Networkexception));
                } else {
                    EditPWD editPWD = new Gson().fromJson(decode, EditPWD.class);
                    if (editPWD.getStu().equals("1")) {
                        // TODO: 2017/5/19 注册
                        if (editPWD.getMsg().contains("密码修改成功,请重新登陆")) {
                            Toast.makeText(context, R.string.changepassword, Toast.LENGTH_SHORT).show();
                            SPUtil.putAndApply(context, "password", passworld);
                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    gotoMain();
                                }
                            }, 1000);
                        }
                    } else {
                        if (editPWD.getMsg().contains("旧密码错误")) {
                            Toast.makeText(context, getString(R.string.OldPassWordIsError), Toast.LENGTH_LONG).show();
                        } else if (editPWD.getMsg().contains("该用户不存在")) {
                            Toast.makeText(context, getString(R.string.account), Toast.LENGTH_LONG).show();
                        } else if (editPWD.getMsg().contains("密码修改失败,请稍候操作")) {
                            Toast.makeText(context, getString(R.string.iserror), Toast.LENGTH_LONG).show();
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
}
