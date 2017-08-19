package cn.edu.nuc.studies.page;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nuc.library.base.BaseFragment;
import cn.edu.nuc.library.utils.OnRecyclerItemListener;
import cn.edu.nuc.studies.ArticleItem;
import cn.edu.nuc.studies.R;


/**
 * Author: Inno Fang
 * Time: 2017/8/16 21:24
 * Description:
 */


public class PageFragment extends BaseFragment implements StudiesPageContract.View {

    private static final String ARG_URL = "url";

    private String url;
    private StudiesPageAdapter mAdapter;
    private StudiesPageContract.Presenter mPresenter;

    private RecyclerView mStudiesRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public static PageFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.url = getArguments().getString(ARG_URL);
        mAdapter = new StudiesPageAdapter(getActivity(), new ArrayList<ArticleItem>(0));
        mPresenter = new StudiesPagePresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.sd_fragment_page;
    }

    @Override
    protected void createView(View view, Bundle savedInstanceState) {
        mStudiesRecyclerView = (RecyclerView) find(R.id.sd_recycler_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) find(R.id.sd_swipe_refresh_layout);

    }

    @Override
    protected void initEvent() {

        mStudiesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mStudiesRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.onHandleParseHTML(url);
            }
        });

        mPresenter.onHandleParseHTML(url);
        setLoadingIndicator(true);
    }

    @Override
    public void setPresenter(StudiesPageContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showList(List<ArticleItem> list) {
        if (list.isEmpty())
            return;

        mAdapter.setList(list);
        mStudiesRecyclerView.addOnItemTouchListener(new OnRecyclerItemListener(mStudiesRecyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder viewHolder) {
                if (viewHolder instanceof StudiesPageViewHolder) {
                    StudiesPageViewHolder vh = (StudiesPageViewHolder) viewHolder;
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(vh.link));
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void setLoadingIndicator(final boolean active) {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(active);
            }
        });
    }
}
