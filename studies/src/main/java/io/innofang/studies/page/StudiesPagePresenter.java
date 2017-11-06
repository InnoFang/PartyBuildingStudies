package io.innofang.studies.page;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import cn.edu.nuc.library.ArticleItem;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: Inno Fang
 * Time: 2017/8/16 21:29
 * Description:
 */


public class StudiesPagePresenter implements StudiesPageContract.Presenter {

    private StudiesPageContract.View mView;

    public StudiesPagePresenter(StudiesPageContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void attach() {

    }

    @Override
    public void detach() {

    }

    @Override
    public void onHandleParseHTML(final String url) {
        mView.setLoadingIndicator(true);
        Observable.create(new ObservableOnSubscribe<ArrayList<ArticleItem>>() {
            @Override
            public void subscribe(ObservableEmitter<ArrayList<ArticleItem>> e) throws Exception {
                ArrayList<ArticleItem> list = new ArrayList<>();
                Document doc = Jsoup.connect(url).get();
                Elements ul = doc.getElementsByClass("list_line");
                for (Element u : ul) {
                    Elements li = u.getElementsByTag("li");
                    for (Element l : li) {
                        String text = l.getElementsByTag("a").text();
                        String href = l.getElementsByTag("a").attr("href");
                        String time = l.getElementsByTag("span").text();
                        list.add(new ArticleItem(text, href, time));
                    }
                }
                e.onNext(list);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<ArticleItem>>() {
                    @Override
                    public void accept(@NonNull ArrayList<ArticleItem> articleItems) throws Exception {
                        mView.showList(articleItems);
                        mView.setLoadingIndicator(false);
                    }
                });
    }
}
