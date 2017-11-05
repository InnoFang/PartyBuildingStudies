package io.innofang.overview_new.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.edu.nuc.library.base.BaseRecyclerAdapter;
import cn.edu.nuc.library.ArticleItem;
import io.innofang.overview_new.R;


/**
 * Author: Inno Fang
 * Time: 2017/8/16 21:29
 * Description:
 */


public class NewsAdapter extends BaseRecyclerAdapter<NewsViewHolder, ArticleItem> {

    public NewsAdapter(Context context, ArrayList<ArticleItem> list) {
        super(context, list);
    }

    @Override
    public int getItemLayoutResId() {
        return R.layout.ov_layout_item;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, int viewType, View view) {
        return new NewsViewHolder(view);
    }
}
