package cn.edu.nuc.studies.page;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import cn.edu.nuc.studies.ArticleItem;
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
        final String host = "http://www.gapp.gov.cn";
        mView.setLoadingIndicator(true);
        Observable.create(new ObservableOnSubscribe<ArrayList<ArticleItem>>() {
            @Override
            public void subscribe(ObservableEmitter<ArrayList<ArticleItem>> e) throws Exception {
                ArrayList<ArticleItem> list = new ArrayList<>();
                Document doc = Jsoup.connect(url).get();
                Elements links = doc.getElementsByClass("fl");
                for (Element link : links) {
                    String href = host + link.attr("href");
                    String text = link.text();
                    list.add(new ArticleItem(text, href));
                }
                e.onNext(list);
            }
        }).subscribeOn(Schedulers.io())
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
