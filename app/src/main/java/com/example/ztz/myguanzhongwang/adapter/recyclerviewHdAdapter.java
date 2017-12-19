package com.example.ztz.myguanzhongwang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ztz.myguanzhongwang.R;
import com.example.ztz.myguanzhongwang.bean.ShouyeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2017/12/15.
 */

public class recyclerviewHdAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ShouyeBean.DataBean.ComicsBean> list;

    public recyclerviewHdAdapter(Context context, List<ShouyeBean.DataBean.ComicsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.hd_lunbotu_layout, parent, false);
            return new LunboViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.hd_recycler_adapter_layout, parent, false);
            return new hdviewholder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LunboViewHolder){
            LunboViewHolder holder2 = (LunboViewHolder) holder;
            ArrayList<String> images = new ArrayList<>();
            images.add("https://image.yunifang.com/yunifang/images/goods/temp/171011162655217457875119759.jpg");
            images.add("https://image.yunifang.com/yunifang/images/goods/temp/17051609265319705925918251.jpg");
            images.add("https://image.yunifang.com/yunifang/images/goods/temp/17051609349138679665088294.jpg");
            images.add("https://image.yunifang.com/yunifang/images/goods/temp/17051609348383766880399479.jpg");
            holder2.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).placeholder(R.drawable.black_background).into(imageView);
                }
            });
            holder2.banner.setImages(images);
            holder2.banner.start();
        }else if (holder instanceof hdviewholder){
            hdviewholder holder1 = (hdviewholder) holder;
            holder1.textTitleHd.setText(list.get(position-1).getTitle());
            Glide.with(context)
                    .load(list.get(position-1)
                            .getCover_image_url())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder1.simpleDraweeHd);
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size()+1;
    }

    static class hdviewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_title_hd)
        TextView textTitleHd;
        @BindView(R.id.simpleDrawee_hd)
        ImageView simpleDraweeHd;

        hdviewholder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class LunboViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.banner)
        Banner banner;

        LunboViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
