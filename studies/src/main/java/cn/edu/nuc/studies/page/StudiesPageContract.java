package cn.edu.nuc.studies.page;

import java.util.List;

import cn.edu.nuc.library.base.BasePresenter;
import cn.edu.nuc.library.base.BaseView;
import cn.edu.nuc.studies.ArticleItem;


/**
 * Author: Inno Fang
 * Time: 2017/8/16 21:29
 * Description:
 */


public class StudiesPageContract {

    interface Presenter extends BasePresenter {

        public void onHandleParseHTML(String url);

    }

    interface View extends BaseView<Presenter> {
        public void showList(List<ArticleItem> list);
        public void setLoadingIndicator(boolean active);
    }

}
