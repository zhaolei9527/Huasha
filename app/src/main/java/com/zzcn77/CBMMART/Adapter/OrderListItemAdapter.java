package com.zzcn77.CBMMART.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.View.MyGridView;

/**
 * Created by 赵磊 on 2017/7/19.
 */

public class OrderListItemAdapter extends BaseAdapter {

    Context c;
    private GridAdapter gridAdapter;

    public OrderListItemAdapter(Context context) {
        this.c = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder ViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.order_listitem_layout, null);
            ViewHolder = new ViewHolder(convertView);
            convertView.setTag(ViewHolder);
            gridAdapter = new GridAdapter(c);
        } else {
            ViewHolder = (ViewHolder) convertView.getTag();
        }
        ViewHolder.MyGridView.setAdapter(gridAdapter);
        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public MyGridView MyGridView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.MyGridView = (MyGridView) rootView.findViewById(R.id.MyGridView);
        }

    }
}
