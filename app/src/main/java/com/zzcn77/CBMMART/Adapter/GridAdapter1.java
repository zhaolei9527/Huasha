package com.zzcn77.CBMMART.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zzcn77.CBMMART.Activity.BigImageActivity;
import com.zzcn77.CBMMART.Bean.Order_nyBean;
import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.Utils.UrlUtils;

/**
 * Created by 赵磊 on 2017/7/19.
 */

public class GridAdapter1 extends BaseAdapter {

    Context c;
    private Intent intent;
    private Order_nyBean.ResBean.GoodBean.ItemBean datas;

    public GridAdapter1(Context context, Order_nyBean.ResBean.GoodBean.ItemBean datas) {
        this.c = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.getImg().size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder ViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.order_picture_layout, null);
            ViewHolder = new GridAdapter1.ViewHolder(convertView);
            convertView.setTag(ViewHolder);
        } else {
            ViewHolder = (GridAdapter1.ViewHolder) convertView.getTag();
        }
        ViewHolder.SimpleDraweeView.setImageURI(UrlUtils.DownloadUrl+datas.getImg().get(position));
        ViewHolder.SimpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(c, BigImageActivity.class);
                intent.putExtra("imgurl",UrlUtils.DownloadUrl+datas.getImg().get(position));
                c.startActivity(intent);
            }
        });
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public SimpleDraweeView SimpleDraweeView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.SimpleDraweeView = (SimpleDraweeView) rootView.findViewById(R.id.SimpleDraweeView);
        }

    }
}
