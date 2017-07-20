package com.zzcn77.CBMMART.Activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zzcn77.CBMMART.Adapter.OrderListItem1Adapter;
import com.zzcn77.CBMMART.Adapter.OrderListItem2Adapter;
import com.zzcn77.CBMMART.Adapter.OrderListItem3Adapter;
import com.zzcn77.CBMMART.Adapter.OrderListItem4Adapter;
import com.zzcn77.CBMMART.Adapter.OrderListItem5Adapter;
import com.zzcn77.CBMMART.Adapter.OrderListItem6Adapter;
import com.zzcn77.CBMMART.Adapter.OrderListItem7Adapter;
import com.zzcn77.CBMMART.Base.BaseActivity;
import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.View.MyListView;

import static com.zzcn77.CBMMART.R.id.MyListview;

/**
 * Created by 赵磊 on 2017/7/19.
 */

public class OrderdetailActivity extends BaseActivity {


    private Toolbar tool_bar;
    private View line;
    private ImageView img_type;
    private TextView tv_type;
    private TextView tv_order_message;
    private MyListView MyListview1;
    private MyListView MyListview2;
    private MyListView MyListview3;
    private MyListView MyListview4;
    private MyListView MyListview5;
    private MyListView MyListview6;
    private MyListView MyListview7;

    private LinearLayout ll_ordercontent;
    private LinearLayout ll_ordercontent2;
    private LinearLayout ll_ordercontent3;
    private LinearLayout ll_ordercontent4;
    private LinearLayout ll_ordercontent5;
    private LinearLayout ll_ordercontent6;
    private LinearLayout ll_ordercontent7;

    @Override
    protected int setthislayout() {
        return R.layout.orderdetail_layout;
    }

    @Override
    protected void initview() {
        tool_bar = (Toolbar) findViewById(R.id.tool_bar);
        line = (View) findViewById(R.id.line);
        img_type = (ImageView) findViewById(R.id.img_type);
        tv_type = (TextView) findViewById(R.id.tv_type);
        tv_order_message = (TextView) findViewById(R.id.tv_order_message);
        ll_ordercontent = (LinearLayout) findViewById(R.id.ll_ordercontent);
        ll_ordercontent2 = (LinearLayout) findViewById(R.id.ll_ordercontent2);
        ll_ordercontent3 = (LinearLayout) findViewById(R.id.ll_ordercontent3);
        ll_ordercontent4 = (LinearLayout) findViewById(R.id.ll_ordercontent4);
        ll_ordercontent5 = (LinearLayout) findViewById(R.id.ll_ordercontent5);
        ll_ordercontent6 = (LinearLayout) findViewById(R.id.ll_ordercontent6);
        ll_ordercontent7 = (LinearLayout) findViewById(R.id.ll_ordercontent7);
        MyListview1 = (MyListView) ll_ordercontent.findViewById(MyListview);
        MyListview2 = (MyListView) ll_ordercontent2.findViewById(MyListview);
        MyListview3 = (MyListView) ll_ordercontent3.findViewById(MyListview);
        MyListview4 = (MyListView) ll_ordercontent4.findViewById(MyListview);
        MyListview5 = (MyListView) ll_ordercontent5.findViewById(MyListview);
        MyListview6 = (MyListView) ll_ordercontent6.findViewById(MyListview);
        MyListview7 = (MyListView) ll_ordercontent7.findViewById(MyListview);
    }

    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {
        MyListview1.setAdapter(new OrderListItem1Adapter(context));
        MyListview2.setAdapter(new OrderListItem2Adapter(context));
        MyListview3.setAdapter(new OrderListItem3Adapter(context));
        MyListview4.setAdapter(new OrderListItem4Adapter(context));
        MyListview5.setAdapter(new OrderListItem5Adapter(context));
        MyListview6.setAdapter(new OrderListItem6Adapter(context));
        MyListview7.setAdapter(new OrderListItem7Adapter(context));
    }

}
