package com.zzcn77.CBMMART.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.View.MyListView;

/**
 * Created by 赵磊 on 2017/7/19.
 */

public class OrderAdapter extends BaseAdapter {

    Context c;
    private ViewGroup.LayoutParams layoutParams = null;
    private OrderListItemAdapter orderListItemAdapter;

    public OrderAdapter(Context context) {
        this.c = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder ViewHolder;
        switch (getItemViewType(position)) {
            case 1:
                if (convertView == null) {
                    convertView = LayoutInflater.from(c).inflate(R.layout.ordercontent_layout, null);
                    ViewHolder = new ViewHolder(convertView);
                    convertView.setTag(ViewHolder);
                    orderListItemAdapter = new OrderListItemAdapter(c);
                } else {
                    ViewHolder = (ViewHolder) convertView.getTag();
                }
                ViewHolder.MyListview.setAdapter(orderListItemAdapter);
                if (layoutParams==null){
                    ViewHolder.ll_ordercontent.measure(0, 0);
                    int measuredHeight = ViewHolder.ll_ordercontent.getMeasuredHeight();
                    layoutParams = ViewHolder.line.getLayoutParams();
                    layoutParams.height = measuredHeight + 10;
                }
                ViewHolder.line.setLayoutParams(layoutParams);
                break;
        }
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public View line;
        public MyListView MyListview;
        public LinearLayout ll_ordercontent;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.line = (View) rootView.findViewById(R.id.line);
            this.MyListview = (MyListView) rootView.findViewById(R.id.MyListview);
            this.ll_ordercontent = (LinearLayout) rootView.findViewById(R.id.ll_ordercontent);
        }

    }
}
