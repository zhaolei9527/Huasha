package com.zzcn77.CBMMART.Activity;

import android.app.Dialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.zzcn77.CBMMART.Adapter.OrderListItem1Adapter;
import com.zzcn77.CBMMART.App;
import com.zzcn77.CBMMART.Base.BaseActivity;
import com.zzcn77.CBMMART.Bean.Order_nyBean;
import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.Utils.DateUtil;
import com.zzcn77.CBMMART.Utils.EasyToast;
import com.zzcn77.CBMMART.Utils.IntentUtil;
import com.zzcn77.CBMMART.Utils.SPUtil;
import com.zzcn77.CBMMART.Utils.UrlUtils;
import com.zzcn77.CBMMART.Utils.Utils;
import com.zzcn77.CBMMART.View.MyListView;
import com.zzcn77.CBMMART.Volley.VolleyInterface;
import com.zzcn77.CBMMART.Volley.VolleyRequest;

import java.util.ArrayList;
import java.util.HashMap;

import static com.zzcn77.CBMMART.R.id.MyListview;
import static com.zzcn77.CBMMART.R.id.tv_order_message;

/**
 * Created by 赵磊 on 2017/7/19.
 */

public class OrderdetailActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar tool_bar;
    private TextView tv_type2;
    private TextView tv_uesrname;
    private MyListView MyListview1;
    private MyListView MyListview2;
    private MyListView MyListview3;
    private MyListView MyListview4;
    private MyListView MyListview5;
    private MyListView MyListview6;
    private MyListView MyListview7;
    private LinearLayout ll_orderhead;
    private LinearLayout ll_ordercontent;
    private LinearLayout ll_ordercontent2;
    private LinearLayout ll_ordercontent3;
    private LinearLayout ll_ordercontent4;
    private LinearLayout ll_ordercontent5;
    private LinearLayout ll_ordercontent6;
    private LinearLayout ll_ordercontent7;
    private LinearLayout ll_error;

    private Dialog dialog;
    private TextView tv_number;
    private TextView tv_day;
    private TextView tv_hour;
    private TextView tv_order_message1;
    private TextView tv_hour1;
    private TextView tv_day1;
    private TextView tv_dayed1;
    private TextView tv_storth1;
    private TextView tv_order_message2;
    private TextView tv_hour2;
    private TextView tv_day2;
    private TextView tv_dayed2;
    private TextView tv_storth2;
    private TextView tv_order_message3;
    private TextView tv_hour3;
    private TextView tv_day3;
    private TextView tv_dayed3;
    private TextView tv_storth3;
    private TextView tv_order_message4;
    private TextView tv_hour4;
    private TextView tv_day4;
    private TextView tv_dayed4;
    private TextView tv_storth4;
    private TextView tv_order_message5;
    private TextView tv_hour5;
    private TextView tv_day5;
    private TextView tv_dayed5;
    private TextView tv_storth5;
    private TextView tv_order_message6;
    private TextView tv_hour6;
    private TextView tv_day6;
    private TextView tv_dayed6;
    private TextView tv_storth6;
    private TextView tv_order_message7;
    private TextView tv_hour7;
    private TextView tv_day7;
    private TextView tv_dayed7;
    private TextView tv_storth7;
    private ImageView img_back;

    @Override
    protected int setthislayout() {
        return R.layout.orderdetail_layout;
    }

    @Override
    protected void initview() {
        img_back = (ImageView) findViewById(R.id.img_back);
        tool_bar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(tool_bar);
        dialog = Utils.showLoadingDialog(context);
        ll_orderhead = (LinearLayout) findViewById(R.id.ll_orderhead);
        tv_number = (TextView) ll_orderhead.findViewById(R.id.tv_ordernumber);
        tv_hour = (TextView) ll_orderhead.findViewById(R.id.tv_hour);
        tv_day = (TextView) ll_orderhead.findViewById(R.id.tv_day);
        ll_ordercontent = (LinearLayout) findViewById(R.id.ll_ordercontent);
        tv_order_message1 = (TextView) ll_ordercontent.findViewById(tv_order_message);
        tv_hour1 = (TextView) ll_ordercontent.findViewById(R.id.tv_hour);
        tv_day1 = (TextView) ll_ordercontent.findViewById(R.id.tv_day);
        tv_dayed1 = (TextView) ll_ordercontent.findViewById(R.id.tv_dayed);
        tv_storth1 = (TextView) ll_ordercontent.findViewById(R.id.tv_storth);

        ll_ordercontent2 = (LinearLayout) findViewById(R.id.ll_ordercontent2);

        tv_order_message2 = (TextView) ll_ordercontent2.findViewById(tv_order_message);
        tv_hour2 = (TextView) ll_ordercontent2.findViewById(R.id.tv_hour);
        tv_day2 = (TextView) ll_ordercontent2.findViewById(R.id.tv_day);
        tv_dayed2 = (TextView) ll_ordercontent2.findViewById(R.id.tv_dayed);
        tv_storth2 = (TextView) ll_ordercontent2.findViewById(R.id.tv_storth);

        ll_ordercontent3 = (LinearLayout) findViewById(R.id.ll_ordercontent3);

        tv_order_message3 = (TextView) ll_ordercontent3.findViewById(tv_order_message);
        tv_hour3 = (TextView) ll_ordercontent3.findViewById(R.id.tv_hour);
        tv_day3 = (TextView) ll_ordercontent3.findViewById(R.id.tv_day);
        tv_dayed3 = (TextView) ll_ordercontent3.findViewById(R.id.tv_dayed);
        tv_storth3 = (TextView) ll_ordercontent3.findViewById(R.id.tv_storth);

        ll_ordercontent4 = (LinearLayout) findViewById(R.id.ll_ordercontent4);

        tv_order_message4 = (TextView) ll_ordercontent4.findViewById(tv_order_message);
        tv_hour4 = (TextView) ll_ordercontent4.findViewById(R.id.tv_hour);
        tv_day4 = (TextView) ll_ordercontent4.findViewById(R.id.tv_day);
        tv_dayed4 = (TextView) ll_ordercontent4.findViewById(R.id.tv_dayed);
        tv_storth4 = (TextView) ll_ordercontent4.findViewById(R.id.tv_storth);

        ll_ordercontent5 = (LinearLayout) findViewById(R.id.ll_ordercontent5);

        tv_order_message5 = (TextView) ll_ordercontent5.findViewById(tv_order_message);
        tv_hour5 = (TextView) ll_ordercontent5.findViewById(R.id.tv_hour);
        tv_day5 = (TextView) ll_ordercontent5.findViewById(R.id.tv_day);
        tv_dayed5 = (TextView) ll_ordercontent5.findViewById(R.id.tv_dayed);
        tv_storth5 = (TextView) ll_ordercontent5.findViewById(R.id.tv_storth);

        ll_ordercontent6 = (LinearLayout) findViewById(R.id.ll_ordercontent6);

        tv_order_message6 = (TextView) ll_ordercontent6.findViewById(tv_order_message);
        tv_hour6 = (TextView) ll_ordercontent6.findViewById(R.id.tv_hour);
        tv_day6 = (TextView) ll_ordercontent6.findViewById(R.id.tv_day);
        tv_dayed6 = (TextView) ll_ordercontent6.findViewById(R.id.tv_dayed);
        tv_storth6 = (TextView) ll_ordercontent6.findViewById(R.id.tv_storth);

        ll_ordercontent7 = (LinearLayout) findViewById(R.id.ll_ordercontent7);

        tv_order_message7 = (TextView) ll_ordercontent7.findViewById(tv_order_message);
        tv_hour7 = (TextView) ll_ordercontent7.findViewById(R.id.tv_hour);
        tv_day7 = (TextView) ll_ordercontent7.findViewById(R.id.tv_day);
        tv_dayed7 = (TextView) ll_ordercontent7.findViewById(R.id.tv_dayed);
        tv_storth7 = (TextView) ll_ordercontent7.findViewById(R.id.tv_storth);

        ll_error = (LinearLayout) findViewById(R.id.ll_error);

        MyListview1 = (MyListView) ll_ordercontent.findViewById(MyListview);
        MyListview2 = (MyListView) ll_ordercontent2.findViewById(MyListview);
        MyListview3 = (MyListView) ll_ordercontent3.findViewById(MyListview);
        MyListview4 = (MyListView) ll_ordercontent4.findViewById(MyListview);
        MyListview5 = (MyListView) ll_ordercontent5.findViewById(MyListview);
        MyListview6 = (MyListView) ll_ordercontent6.findViewById(MyListview);
        MyListview7 = (MyListView) ll_ordercontent7.findViewById(MyListview);
        tv_type2 = (TextView) ll_ordercontent2.findViewById(R.id.tv_type);
        tv_type2.setText("Complete the production & Installation test");
        tv_uesrname = (TextView) ll_orderhead.findViewById(R.id.tv_uesrname);
        tv_uesrname.setText(String.valueOf(SPUtil.get(context, "username", "")));
    }

    @Override
    protected void initListener() {
        img_back.setOnClickListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        App.queues.cancelAll("order_ny");
    }

    @Override
    protected void initData() {
        if (!IntentUtil.isBundleEmpty(getIntent())) {
            String id = getIntent().getStringExtra("id");
            getgoodcontent(id);
        }
    }

    private void getgoodcontent(String id) {
        dialog.show();
        HashMap<String, String> params = new HashMap<>();
        params.put("key", UrlUtils.key);
        params.put("id", id);
        params.put("uid", String.valueOf(SPUtil.get(context, "id", "-1")));
        VolleyRequest.RequestPost(context, UrlUtils.BaseUrl + "order_ny", "order_ny", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                dialog.dismiss();
                ll_error.setVisibility(View.GONE);
                if (result.isEmpty()) {
                    EasyToast.showShort(context, getString(R.string.Networkexception));
                } else {
                    Order_nyBean Order_nyBean = new Gson().fromJson(result, Order_nyBean.class);
                    tv_number.setText(Order_nyBean.getRes().getOrder_num());
                    tv_day.setText(DateUtil.getDay(Long.valueOf(Order_nyBean.getRes().getAdd_time())));
                    tv_hour.setText(DateUtil.getMillon(Long.valueOf(Order_nyBean.getRes().getAdd_time())));
                    if (String.valueOf(Order_nyBean.getStu()).equals("1")) {
                        for (int i = 0; i < Order_nyBean.getRes().getGood().size(); i++) {
                            if ("1".equals(Order_nyBean.getRes().getGood().get(i).getStu())) {
                                tv_order_message1.setText(Order_nyBean.getRes().getGood().get(i).getShuoming());
                                tv_day1.setText(DateUtil.getDay(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                tv_hour1.setText(DateUtil.getMillon(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                MyListview1.setAdapter(new OrderListItem1Adapter(context, (ArrayList) Order_nyBean.getRes().getGood().get(i).getItem()));
                            } else if ("2".equals(Order_nyBean.getRes().getGood().get(i).getStu())) {
                                tv_order_message2.setText(Order_nyBean.getRes().getGood().get(i).getShuoming());
                                tv_day2.setText(DateUtil.getDay(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                tv_hour2.setText(DateUtil.getMillon(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                MyListview2.setAdapter(new OrderListItem1Adapter(context, (ArrayList) Order_nyBean.getRes().getGood().get(i).getItem()));
                            } else if ("3".equals(Order_nyBean.getRes().getGood().get(i).getStu())) {
                                tv_order_message3.setText(Order_nyBean.getRes().getGood().get(i).getShuoming());
                                tv_day3.setText(DateUtil.getDay(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                tv_hour3.setText(DateUtil.getMillon(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                MyListview3.setAdapter(new OrderListItem1Adapter(context, (ArrayList) Order_nyBean.getRes().getGood().get(i).getItem()));
                            } else if ("4".equals(Order_nyBean.getRes().getGood().get(i).getStu())) {
                                tv_order_message4.setText(Order_nyBean.getRes().getGood().get(i).getShuoming());
                                tv_day4.setText(DateUtil.getDay(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                tv_hour4.setText(DateUtil.getMillon(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                MyListview4.setAdapter(new OrderListItem1Adapter(context, (ArrayList) Order_nyBean.getRes().getGood().get(i).getItem()));
                            } else if ("5".equals(Order_nyBean.getRes().getGood().get(i).getStu())) {
                                tv_order_message5.setText(Order_nyBean.getRes().getGood().get(i).getShuoming());
                                tv_day5.setText(DateUtil.getDay(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                tv_hour5.setText(DateUtil.getMillon(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                MyListview5.setAdapter(new OrderListItem1Adapter(context, (ArrayList) Order_nyBean.getRes().getGood().get(i).getItem()));
                            } else if ("6".equals(Order_nyBean.getRes().getGood().get(i).getStu())) {
                                tv_order_message6.setText(Order_nyBean.getRes().getGood().get(i).getShuoming());
                                tv_day6.setText(DateUtil.getDay(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                tv_hour6.setText(DateUtil.getMillon(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                MyListview6.setAdapter(new OrderListItem1Adapter(context, (ArrayList) Order_nyBean.getRes().getGood().get(i).getItem()));
                            }  else if ("8".equals(Order_nyBean.getRes().getGood().get(i).getStu())) {
                                tv_order_message7.setText(Order_nyBean.getRes().getGood().get(i).getShuoming());
                                tv_day7.setText(DateUtil.getDay(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                tv_hour7.setText(DateUtil.getMillon(Long.valueOf(Order_nyBean.getRes().getGood().get(i).getAdd_time())));
                                MyListview7.setAdapter(new OrderListItem1Adapter(context, (ArrayList) Order_nyBean.getRes().getGood().get(i).getItem()));
                            }
                        }
                    } else {
                        EasyToast.showShort(context, getString(R.string.Abnormalserver));
                    }
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                dialog.dismiss();
                ll_error.setVisibility(View.VISIBLE);
                EasyToast.showShort(context, getString(R.string.Abnormalserver));

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;

        }
    }
}
