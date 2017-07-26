package com.zzcn77.CBMMART.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zzcn77.CBMMART.Bean.Order_nyBean;
import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.View.MyGridView;

import java.util.ArrayList;

/**
 * Created by 赵磊 on 2017/7/19.
 */

public class OrderListItem1Adapter extends BaseAdapter {

    Context c;
    ArrayList<Order_nyBean.ResBean.GoodBean.ItemBean> datas = new ArrayList<>();

    public OrderListItem1Adapter(Context context, ArrayList datas) {
        this.c = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
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

        ViewHolder.tv_title.setText(datas.get(position).getTitle());
        GridAdapter1 gridAdapter = new GridAdapter1(c, datas.get(position));
        if (datas.get(position).getImg() != null && datas.get(position).getImg().size() > 0)
            ViewHolder.MyGridView.setAdapter(gridAdapter);
        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public MyGridView MyGridView;
        public TextView tv_title;


        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.MyGridView = (MyGridView) rootView.findViewById(R.id.MyGridView);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        }

    }
}
