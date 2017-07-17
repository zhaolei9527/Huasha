package com.zzcn77.CBMMART.Activity;

import android.view.Window;
import android.view.WindowManager;

import com.zzcn77.CBMMART.Base.BaseActivity;
import com.zzcn77.CBMMART.R;

/**
 * Created by 赵磊 on 2017/7/15.
 */

public class ForgetActivity extends BaseActivity {
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

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
