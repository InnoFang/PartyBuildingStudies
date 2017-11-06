package io.innofang.overview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.edu.nuc.library.ArticleItem;
import cn.edu.nuc.library.base.BaseFragment;
import cn.edu.nuc.library.utils.OnRecyclerItemListener;
import io.innofang.overview.news.NewsAdapter;
import io.innofang.overview.news.NewsContract;
import io.innofang.overview.news.NewsPresenter;
import io.innofang.overview.news.NewsViewHolder;

/**
 * Author: Inno Fang
 * Time: 2017/8/19 12:26
 * Description:
 */

@Route(path = "/pbs_ov_new_fragment/1")
public class OverviewFragment extends BaseFragment implements NewsContract.View {

    private static final String NEWS_URL = "http://www.xinhuanet.com/politics/liangxueyizuo/zxbb.htm";

    private MZBannerView<Integer> mBanner;
    private RecyclerView mNewsRecyclerView;

    private NewsAdapter mAdapter;
    private NewsContract.Presenter mPresenter;
    private ProgressBar mProgressBar;

    public static OverviewFragment newInstance() {
        return new OverviewFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ov_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new NewsAdapter(getActivity(), new ArrayList<ArticleItem>(0));
        mPresenter = new NewsPresenter(this);
    }

    @Override
    protected void createView(View view, Bundle savedInstanceState) {
        mBanner = (MZBannerView<Integer>) find(R.id.banner);
        mNewsRecyclerView = (RecyclerView) find(R.id.news_recycler_view);
        mProgressBar = (ProgressBar) find(R.id.loading_news_progress_bar);
    }

    @Override
    protected void initEvent() {

        mNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mNewsRecyclerView.setAdapter(mAdapter);

        List<Integer> res = Arrays.asList(
                R.drawable.ov_banner_1,
                R.drawable.ov_banner_2,
                R.drawable.ov_banner_3,
                R.drawable.ov_banner_4,
                R.drawable.ov_banner_5);

        mBanner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int i) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.xinhuanet.com/politics/liangxueyizuo/index.htm"));
                startActivity(intent);
            }
        });

        mBanner.setPages(res, new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });

        mPresenter.onHandleParseHTML(NEWS_URL);
    }

    @Override
    public void onPause() {
        super.onPause();
        mBanner.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mBanner.start();
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showList(List<ArticleItem> list) {
        if (list.isEmpty())
            return;

        mAdapter.setList(list);
        mNewsRecyclerView.addOnItemTouchListener(new OnRecyclerItemListener(mNewsRecyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder viewHolder) {
                if (viewHolder instanceof NewsViewHolder) {
                    NewsViewHolder vh = (NewsViewHolder) viewHolder;
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(vh.link));
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void showLoading(boolean active) {
        mProgressBar.setVisibility(active ? View.VISIBLE : View.GONE);
    }
}
