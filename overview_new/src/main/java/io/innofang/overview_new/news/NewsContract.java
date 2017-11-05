package io.innofang.overview_new.news;

import java.util.List;

import cn.edu.nuc.library.base.BasePresenter;
import cn.edu.nuc.library.base.BaseView;
import cn.edu.nuc.library.ArticleItem;


/**
 * Author: Inno Fang
 * Time: 2017/8/16 21:29
 * Description:
 */


public class NewsContract {

    public interface Presenter extends BasePresenter {

        public void onHandleParseHTML(String url);

    }

    public interface View extends BaseView<Presenter> {
        public void showList(List<ArticleItem> list);
        public void showLoading(boolean active);
    }

}
