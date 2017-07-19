package com.zzcn77.CBMMART.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

import com.zzcn77.CBMMART.Activity.BigImageActivity;
import com.zzcn77.CBMMART.R;

/**
 * Created by 赵磊 on 2017/7/19.
 */

public class GridAdapter extends BaseAdapter {

    Context c;
    private Intent intent;

    public GridAdapter(Context context) {
        this.c = context;
    }

    @Override
    public int getCount() {
        return 5;
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
        ViewHolder ViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.order_picture_layout, null);
            ViewHolder = new GridAdapter.ViewHolder(convertView);
            convertView.setTag(ViewHolder);
        } else {
            ViewHolder = (GridAdapter.ViewHolder) convertView.getTag();
        }
        ViewHolder.SimpleDraweeView.setImageURI("http://upload-images.jianshu.io/upload_images/5124923-7a6d81d7b864f811.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        ViewHolder.SimpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(c, BigImageActivity.class);
                intent.putExtra("imgurl", "http://upload-images.jianshu.io/upload_images/5124923-7a6d81d7b864f811.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
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
