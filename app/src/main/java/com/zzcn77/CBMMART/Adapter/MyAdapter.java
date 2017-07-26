package com.zzcn77.CBMMART.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzcn77.CBMMART.Bean.OrderBean;
import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.Utils.DateUtil;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context mContext;
    private ArrayList<OrderBean.ResBean> datas = new ArrayList();

    public ArrayList<OrderBean.ResBean> getDatas() {
        return datas;
    }

    public MyAdapter(List<OrderBean.ResBean> list, Context context) {
        this.datas = (ArrayList<OrderBean.ResBean>) list;
        this.mContext = context;
        notifyDataSetChanged();
    }

    public void setDatas(ArrayList datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_base, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        switch (datas.get(position).getStu()) {
            case "-1":
                holder.tv_type.setText("Place the order");
                break;
            case "1":
                holder.tv_type.setText("Start the production");
                break;
            case "2":
                holder.tv_type.setText("Complete the production & Installation test");
                break;
            case "3":
                holder.tv_type.setText("Packing");
                break;
            case "4":
                holder.tv_type.setText("Loading the container");
                break;
            case "5":
                holder.tv_type.setText("Custom release:Yes");
                break;
            case "6":
                holder.tv_type.setText("ETD");
                break;
            case "7":
                holder.tv_type.setText("ETA");
                break;
            case "8":
                holder.tv_type.setText("Custom documents have been sent out");
                break;
            case "9":
                holder.tv_type.setText("Order finished");
                break;
        }
        holder.tv_number.setText(datas.get(position).getOrder_num());
        holder.tv_delyverytime_day.setText(DateUtil.getDay(Long.valueOf(datas.get(position).getJf_time())));
        holder.tv_ordertime_day.setText(DateUtil.getDay(Long.valueOf(datas.get(position).getSc_time())));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img_state;
        public TextView tv_type;
        public TextView tv_number;
        public TextView tv_delyverytime_day;
        public TextView tv_ordertime_day;

        public ViewHolder(View itemView) {
            super(itemView);
            this.rootView = itemView;
            this.img_state = (ImageView) rootView.findViewById(R.id.img_state);
            this.tv_type = (TextView) rootView.findViewById(R.id.tv_type);
            this.tv_number = (TextView) rootView.findViewById(R.id.tv_number);
            this.tv_delyverytime_day = (TextView) rootView.findViewById(R.id.tv_delyverytime_day);
            this.tv_ordertime_day = (TextView) rootView.findViewById(R.id.tv_ordertime_day);
        }
    }

}
