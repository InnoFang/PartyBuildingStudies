package cn.edu.nuc.studies.page;

import android.view.View;
import android.widget.TextView;

import cn.edu.nuc.library.base.BaseViewHolder;
import cn.edu.nuc.studies.ArticleItem;
import cn.edu.nuc.studies.R;


/**
 * Author: Inno Fang
 * Time: 2017/8/16 21:30
 * Description:
 */


public class StudiesPageViewHolder extends BaseViewHolder<ArticleItem> {

    private TextView tvTitle;

    public String link;

    public StudiesPageViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) find(R.id.sd_content_title_text_view);
    }

    @Override
    public void bindHolder(ArticleItem model) {
        tvTitle.setText(model.getTitle());
        link = model.getLink();
    }
}
