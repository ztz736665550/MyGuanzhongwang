package com.example.ztz.myguanzhongwang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ztz.myguanzhongwang.R;
import com.example.ztz.myguanzhongwang.bean.ShouyeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2017/12/16.
 */

public class recyclerviewZYAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ShouyeBean.DataBean.ComicsBean> list;

    public recyclerviewZYAdapter(Context context, List<ShouyeBean.DataBean.ComicsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerviewzyadapterlayout, parent, false);
        return new zyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        zyViewHolder holder1 = (zyViewHolder) holder;
        holder1.textTitleZy.setText(list.get(position).getTitle());
        holder1.textNameZy.setText(list.get(position).getLabel_text());
    }

    @Override
    public int getItemCount() {
        return list==null ? 0 :list.size();
    }

    static class zyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_title_zy)
        TextView textTitleZy;
        @BindView(R.id.text_name_zy)
        TextView textNameZy;

        zyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
