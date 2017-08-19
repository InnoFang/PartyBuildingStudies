package cn.edu.nuc.overview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.Arrays;
import java.util.List;

import cn.edu.nuc.library.base.BaseFragment;

/**
 * Author: Inno Fang
 * Time: 2017/8/19 12:26
 * Description:
 */

@Route(path = "/pbs_ov_fragment/1")
public class OverviewFragment extends BaseFragment {

    private MZBannerView<Integer> mBanner;
    private WebView mWebView;

    public static OverviewFragment newInstance() {
        return new OverviewFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ov_fragment;
    }

    @Override
    protected void createView(View view, Bundle savedInstanceState) {
        mBanner = (MZBannerView<Integer>) find(R.id.banner);
        mWebView = (WebView) find(R.id.content_web_view);
    }

    @Override
    protected void initEvent() {

        List<Integer> res = Arrays.asList(
                R.drawable.banner_1,
                R.drawable.banner_2,
                R.drawable.banner_3,
                R.drawable.banner_4,
                R.drawable.banner_5);

        mBanner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int i) {

            }
        });

        mBanner.setPages(res, new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/ov_index.html");
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
}
