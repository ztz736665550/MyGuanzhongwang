package com.example.ztz.myguanzhongwang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ztz.myguanzhongwang.R;
import com.example.ztz.myguanzhongwang.bean.GuanliBean;
import com.example.ztz.myguanzhongwang.bean.ShouyeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2017/12/16.
 */

public class WobmRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<GuanliBean.DataBean> list;
    public WobmRecyclerviewAdapter(Context context, List<GuanliBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wobmrecyclerviewadapter_layout, parent, false);
        return new recycelrviewholder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        recycelrviewholder holder1 = (recycelrviewholder) holder;
        holder1.textTitleBm.setText(list.get(position).getName());
        holder1.textNameBm.setText(list.get(position).getCreatetime());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class recycelrviewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_title_bm)
        TextView textTitleBm;
        @BindView(R.id.text_name_bm)
        TextView textNameBm;

        recycelrviewholder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
