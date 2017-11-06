package io.innofang.overview.news;

import android.view.View;
import android.widget.TextView;

import cn.edu.nuc.library.base.BaseViewHolder;
import cn.edu.nuc.library.ArticleItem;
import io.innofang.overview.R;


/**
 * Author: Inno Fang
 * Time: 2017/8/16 21:30
 * Description:
 */


public class NewsViewHolder extends BaseViewHolder<ArticleItem> {

    private TextView tvTitle;
    private TextView tvTime;

    public String link;

    public NewsViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) find(R.id.sd_content_title_text_view);
        tvTime = (TextView) find(R.id.sd_time_text_view);
    }

    @Override
    public void bindHolder(ArticleItem model) {
        tvTitle.setText(model.getTitle());
        tvTime.setText(model.getTime());
        link = model.getLink();
    }
}
