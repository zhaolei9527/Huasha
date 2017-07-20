package com.zzcn77.CBMMART.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.View.MyGridView;

import java.util.ArrayList;

/**
 * Created by 赵磊 on 2017/7/19.
 */

public class OrderListItem2Adapter extends BaseAdapter {

    Context c;
    private GridAdapter1 gridAdapter;

    public OrderListItem2Adapter(Context context) {
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
        } else {
            ViewHolder = (ViewHolder) convertView.getTag();
        }
        if (position == 0) {
            ArrayList<Object> objects = new ArrayList<>();
            objects.add("");
            objects.add("");
            objects.add("");
            gridAdapter=new GridAdapter1(c,objects);
            ViewHolder.MyGridView.setAdapter(gridAdapter);
        }else if (position==1){
            ArrayList<Object> objects = new ArrayList<>();
            objects.add("");
            objects.add("");
            objects.add("");
            objects.add("");
            gridAdapter=new GridAdapter1(c,objects);
            ViewHolder.MyGridView.setAdapter(gridAdapter);
        }else if (position==2){
            ArrayList<Object> objects = new ArrayList<>();
            objects.add("");
            objects.add("");
            gridAdapter=new GridAdapter1(c,objects);
            ViewHolder.MyGridView.setAdapter(gridAdapter);
        }
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
