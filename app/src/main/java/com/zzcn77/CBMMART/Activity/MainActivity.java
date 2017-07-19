package com.zzcn77.CBMMART.Activity;

import android.Manifest;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.zzcn77.CBMMART.Adapter.MyAdapter;
import com.zzcn77.CBMMART.Base.BaseActivity;
import com.zzcn77.CBMMART.Bean.OrderBean;
import com.zzcn77.CBMMART.Bean.VersionBean;
import com.zzcn77.CBMMART.HidingScrollListener;
import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.Utils.EasyToast;
import com.zzcn77.CBMMART.Utils.SPUtil;
import com.zzcn77.CBMMART.Utils.UrlUtils;
import com.zzcn77.CBMMART.Utils.Utils;
import com.zzcn77.CBMMART.View.ProgressView;
import com.zzcn77.CBMMART.View.UpDateDialog;
import com.zzcn77.CBMMART.Volley.VolleyInterface;
import com.zzcn77.CBMMART.Volley.VolleyRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.fangx.haorefresh.HaoRecyclerView;
import me.fangx.haorefresh.LoadMoreListener;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    Toolbar mToolBar;
    SwipeRefreshLayout refresh;
    HaoRecyclerView mRecyclerView;
    MyAdapter mAdapter;
    private ImageView img_setting;
    private BroadcastReceiver receiver;
    private int p = 1;
    private LinearLayout ll_empty;
    private LinearLayout ll_error;
    private LinearLayout ll_tryget;
    private Dialog dialog;
    private AdapterView.OnItemClickListener onItemClickListener;

    @Override
    protected int setthislayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initview() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(context.getResources().getColor(R.color.colorPrimary));
        }
        initToolBar();
        img_setting = (ImageView) findViewById(R.id.img_setting);
        ll_empty = (LinearLayout) findViewById(R.id.ll_empty);
        ll_error = (LinearLayout) findViewById(R.id.ll_error);
        img_setting.setOnClickListener(this);
        refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        refresh.setProgressViewEndTarget(false, (int) getResources().getDimension(R.dimen.x105));
        refresh.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        p = 1;
                        mAdapter.getDatas().clear();
                        getData();
                    }
                }, 0);
            }
        });
        ll_tryget = (LinearLayout) ll_error.findViewById(R.id.ll_tryget);
        ll_tryget.setOnClickListener(this);
        mRecyclerView = (HaoRecyclerView) findViewById(R.id.ce_shi_lv);
        LinearLayoutManager line = new LinearLayoutManager(this);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(line);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(this);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(0xff69b3e0);
        mRecyclerView.setFootLoadingView(progressView);
        getData();
        TextView textView = new TextView(this);
        textView.setText("-NOTMORE-");
        mRecyclerView.setFootEndView(textView);
        mRecyclerView.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        p = p + 1;
                        getData();
                    }
                }, 0);
            }
        });

        mRecyclerView.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void hide() {
                mToolBar.animate().translationY(-mToolBar.getHeight()).setInterpolator(new AccelerateDecelerateInterpolator());
            }

            @Override
            public void show() {
                mToolBar.animate().translationY(0).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });
    }

    @Override
    protected void initListener() {
        Acp.getInstance(context).request(new AcpOptions.Builder()
                        .setPermissions(Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                        .setDeniedMessage(getString(R.string.requstPerminssions))
                /*以下为自定义提示语、按钮文字
                .setDeniedMessage()
                .setDeniedCloseBtn()
                .setDeniedSettingBtn()
                .setRationalMessage()
                .setRationalBtn()*/
                        .build(),
                new AcpListener() {
                    @Override
                    public void onGranted() {

                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        Toast.makeText(context, R.string.Thepermissionapplicationisrejected, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void initData() {
        boolean connected = Utils.isConnected(context);
        if (connected) {
            updataversion();
        } else {
            if (context != null) {
                EasyToast.showShort(context, getString(R.string.Notconnect));
            }
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
                        try {
                            int versionCode = getversionCode();
                            int Android_bnum = Integer.parseInt(versionBean.getRes().getAndroid_bnum());
                            if (versionCode < Android_bnum) {
                                UpDateDialog upDateDialog = new UpDateDialog();
                                upDateDialog.UpDateDialog(context, getString(R.string.Importantupdate), versionBean.getRes().getAndroid_content(), versionBean.getRes().getAndroid());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        EasyToast.showShort(context, getString(R.string.Abnormalserver));
                    }
                }

            }

            @Override
            public void onMyError(VolleyError error) {
                EasyToast.showShort(context, getString(R.string.Abnormalserver));
            }
        });

    }

    private int getversionCode() throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(), 0);
        int versionCode = packInfo.versionCode;
        return versionCode;
    }
    //--------------使用onKeyDown()干掉他--------------

    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - firstTime > 2000) {
                Toast.makeText(MainActivity.this, R.string.Clicktheexitprogramagain, Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initToolBar() {
        mToolBar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolBar);
    }

    public void getData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("key", UrlUtils.key);
        params.put("p", String.valueOf(p));
        params.put("uid", String.valueOf(SPUtil.get(context, "id", "-1")));
        VolleyRequest.RequestPost(context, UrlUtils.BaseUrl + "order", "order", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (refresh != null)
                    refresh.setRefreshing(false);
                String decode = Utils.decode(result);
                Log.d("MainActivity", decode);
                if (decode.isEmpty()) {
                    EasyToast.showShort(context, getString(R.string.Networkexception));
                    ll_error.setVisibility(View.VISIBLE);
                    ll_empty.setVisibility(View.GONE);
                } else {
                    OrderBean OrderBean = new Gson().fromJson(decode, OrderBean.class);
                    if (OrderBean.getStu().equals("1")) {
                        ll_error.setVisibility(View.GONE);
                        ll_empty.setVisibility(View.GONE);
                        if (p == 1) {
                            mAdapter = new MyAdapter(OrderBean.getRes(), context);
                            mRecyclerView.setAdapter(mAdapter);
                            //已经封装好的点击事件
                            if (onItemClickListener == null) {
                                onItemClickListener = new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        startActivity(new Intent(context, OrderdetailActivity.class));
                                    }
                                };
                            }
                            mRecyclerView.setOnItemClickListener(onItemClickListener);
                        } else {
                            mAdapter.setDatas((ArrayList) OrderBean.getRes());
                        }
                        if (OrderBean.getRes().size() < 10) {
                            mRecyclerView.setCanloadMore(false);
                            mRecyclerView.loadMoreEnd();
                        } else {
                            mRecyclerView.setCanloadMore(true);
                            mRecyclerView.loadMoreComplete();
                        }
                        if (mAdapter != null)
                            mAdapter.notifyDataSetChanged();
                    } else {
                        if (p == 1) {
                            if (OrderBean.getStu().contains("0")) {
                                ll_empty.setVisibility(View.VISIBLE);
                                ll_error.setVisibility(View.GONE);
                            } else {
                                if (mAdapter != null) {
                                    mAdapter.getDatas().clear();
                                    mAdapter.notifyDataSetChanged();
                                }
                                ll_error.setVisibility(View.VISIBLE);
                                ll_empty.setVisibility(View.GONE);
                                EasyToast.showShort(context, getString(R.string.Abnormalserver));
                            }
                        }
                    }
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                if (dialog != null) {
                    dialog.dismiss();
                }
                mAdapter.getDatas().clear();
                mAdapter.notifyDataSetChanged();
                ll_error.setVisibility(View.VISIBLE);
                ll_empty.setVisibility(View.GONE);
                error.printStackTrace();
                Toast.makeText(MainActivity.this, getString(R.string.hasError), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_setting:
                startActivity(new Intent(context, SettingActivity.class));
                break;
            case R.id.ll_tryget:
                dialog = Utils.showLoadingDialog(context);
                dialog.show();
                getData();
                break;
        }
    }

}
