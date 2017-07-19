package com.zzcn77.CBMMART.Activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.zzcn77.CBMMART.Base.BaseActivity;
import com.zzcn77.CBMMART.Bean.VersionBean;
import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.Utils.EasyToast;
import com.zzcn77.CBMMART.Utils.SPUtil;
import com.zzcn77.CBMMART.Utils.UrlUtils;
import com.zzcn77.CBMMART.Utils.Utils;
import com.zzcn77.CBMMART.View.UpDateDialog;
import com.zzcn77.CBMMART.Volley.VolleyInterface;
import com.zzcn77.CBMMART.Volley.VolleyRequest;

import java.util.HashMap;

/**
 * Created by 赵磊 on 2017/7/15.
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private ImageView img_back;
    private RelativeLayout rl_changepassworld;
    private RelativeLayout rl_update;
    private RelativeLayout rl_exit;
    private TextView tv_version;
    private BroadcastReceiver receiver;

    @Override
    protected int setthislayout() {
        return R.layout.setting_layout;
    }

    @Override
    protected void initview() {
        img_back = (ImageView) findViewById(R.id.img_back);
        rl_changepassworld = (RelativeLayout) findViewById(R.id.rl_changepassworld);
        rl_update = (RelativeLayout) findViewById(R.id.rl_update);
        rl_exit = (RelativeLayout) findViewById(R.id.rl_exit);
        tv_version = (TextView) findViewById(R.id.tv_version);
    }

    @Override
    protected void initListener() {
        img_back.setOnClickListener(this);
        rl_changepassworld.setOnClickListener(this);
        rl_update.setOnClickListener(this);
        rl_exit.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        try {
            String versionName = getVersionName();
            tv_version.setText(versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        IntentFilter intentFilter = new IntentFilter();
        //设置接收广播的类型
        intentFilter.addAction("LoginActivityIsStart");
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                finish();
            }
        };
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    private void updataversion() {
        final Dialog dialog = Utils.showLoadingDialog(context);
        dialog.show();
        HashMap<String, String> params = new HashMap<>();
        params.put("key", UrlUtils.key);
        VolleyRequest.RequestPost(context, UrlUtils.BaseUrl + "version", "version", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = Utils.decode(result);
                if (decode.isEmpty()) {
                    EasyToast.showShort(context, getString(R.string.Networkexception));
                } else {
                    VersionBean versionBean = new Gson().fromJson(decode, VersionBean.class);
                    if (String.valueOf(versionBean.getStu()).equals("1")) {
                        if (dialog !=null)
                            dialog.dismiss();
                        try {
                            int versionCode = getversionCode();
                            int Android_bnum = Integer.parseInt(versionBean.getRes().getAndroid_bnum());
                            if (versionCode < Android_bnum) {
                                UpDateDialog upDateDialog = new UpDateDialog();
                                upDateDialog.UpDateDialog(context, getString(R.string.Importantupdate), versionBean.getRes().getAndroid_content(), versionBean.getRes().getAndroid());
                            }else {
                                if (context!=null)
                                    Toast.makeText(context, R.string.Isthelatestversion, Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (dialog !=null)
                            dialog.dismiss();
                        EasyToast.showShort(context, getString(R.string.Abnormalserver));
                    }
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                if (dialog !=null)
                    dialog.dismiss();
                EasyToast.showShort(context, getString(R.string.Abnormalserver));
            }
        });

    }
    private String getVersionName() throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(), 0);
        String version = packInfo.versionName;
        return version;
    }

    private int getversionCode() throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(), 0);
        int versionCode = packInfo.versionCode;
        return versionCode;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_changepassworld:
                startActivity(new Intent(context, ChangePassWorldActivity.class));
                break;
            case R.id.img_back:
                finish();
                break;
            case R.id.rl_update:
                boolean connected = Utils.isConnected(context);
                if (connected) {
                    updataversion();
                } else {
                    if (context != null) {
                        EasyToast.showShort(context, getString(R.string.Notconnect));
                    }
                }
                break;
            case R.id.rl_exit:
                if (!SPUtil.get(context, "id", "").toString().isEmpty()) {
                    // TODO Auto-generated method stub
                    new AlertDialog.Builder(context).setTitle(R.string.message)//设置对话框标题
                            .setMessage(R.string.Areyouexit)//设置显示的内容
                            .setPositiveButton(R.string.exit, new DialogInterface.OnClickListener() {//添加确定按钮
                                @Override
                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                                    // TODO Auto-generated method stub
                                    dialog.dismiss();
                                    SPUtil.remove(context, "id");
                                    SPUtil.remove(context, "password");
                                    SPUtil.remove(context, "email");
                                    startActivity(new Intent(context, LoginActivity.class));
                                    finish();
                                }
                            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {//添加返回按钮
                        @Override
                        public void onClick(DialogInterface dialog, int which) {//响应事件
                            dialog.dismiss();
                        }
                    }).show();//在按键响应事件中显示此对话框
                }
                break;
        }
    }

}
