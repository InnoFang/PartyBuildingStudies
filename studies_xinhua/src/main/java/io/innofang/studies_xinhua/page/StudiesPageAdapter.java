package io.innofang.studies_xinhua.page;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.edu.nuc.library.ArticleItem;
import cn.edu.nuc.library.base.BaseRecyclerAdapter;
import io.innofang.studies_xinhua.R;


/**
 * Author: Inno Fang
 * Time: 2017/8/16 21:29
 * Description:
 */


public class StudiesPageAdapter extends BaseRecyclerAdapter<StudiesPageViewHolder, ArticleItem> {

    public StudiesPageAdapter(Context context, ArrayList<ArticleItem> list) {
        super(context, list);
    }

    @Override
    public int getItemLayoutResId() {
        return R.layout.sd_layout_item;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, int viewType, View view) {
        return new StudiesPageViewHolder(view);
    }
}
