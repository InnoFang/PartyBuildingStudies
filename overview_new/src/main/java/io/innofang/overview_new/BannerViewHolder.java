package io.innofang.overview_new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.zhouwei.mzbanner.holder.MZViewHolder;

/**
 * Author: Inno Fang
 * Time: 2017/8/19 12:37
 * Description:
 */


public class BannerViewHolder implements MZViewHolder<Integer> {
    private ImageView mImageView;
    @Override
    public View createView(Context context) {
        // 返回页面布局
        View view = LayoutInflater.from(context).inflate(R.layout.ov_layout_banner_item, null);
        mImageView = (ImageView) view.findViewById(R.id.banner_image_view);
        return view;
    }

    @Override
    public void onBind(Context context, int position, Integer data) {
        // 数据绑定
        mImageView.setImageResource(data);
    }
}