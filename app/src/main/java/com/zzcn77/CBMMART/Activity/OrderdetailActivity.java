package com.zzcn77.CBMMART.Activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.zzcn77.CBMMART.Adapter.OrderAdapter;
import com.zzcn77.CBMMART.Base.BaseActivity;
import com.zzcn77.CBMMART.R;

/**
 * Created by 赵磊 on 2017/7/19.
 */

public class OrderdetailActivity extends BaseActivity {

    private Toolbar tool_bar;
    private ListView lv_order;

    @Override
    protected int setthislayout() {
        return R.layout.orderdetail_layout;
    }
    @Override
    protected void initview() {
        lv_order= (ListView) findViewById(R.id.lv_order);
        OrderAdapter orderAdapter = new OrderAdapter(context);
        //添加头部
        lv_order.addHeaderView(View.inflate(context,R.layout.orderhead_layout,null));
        lv_order.addFooterView(View.inflate(context,R.layout.orderfoot_layout,null));
        lv_order.setAdapter(orderAdapter);
        lv_order.setDivider(null);//去除listview的下划线
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


}
