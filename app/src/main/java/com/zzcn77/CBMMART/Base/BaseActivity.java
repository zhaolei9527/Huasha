package com.zzcn77.CBMMART.Base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.badoo.mobile.util.WeakHandler;
/**
 * Created by 赵磊 on 2017/5/12.
 */
/**
 *
 * ━━━━━━神兽保佑━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 *
 * ━━━━━━代码无BUG━━━━━━
 */
public abstract class BaseActivity extends Activity {
    protected WeakHandler mHandler;
    protected Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ready();
        setContentView(setthislayout());
        context = this;
        mHandler = new WeakHandler();
        initview();
        initListener();
        initData();
    }

    protected void ready() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract int setthislayout();

    protected abstract void initview();

    protected abstract void initListener();

    protected abstract void initData();

}