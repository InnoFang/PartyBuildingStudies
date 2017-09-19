package io.innofang.studies_xinhua;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.edu.nuc.library.base.BaseFragment;
import cn.edu.nuc.studies.StudiesViewPagerAdapter;
import io.innofang.studies_xinhua.page.PageFragment;

/**
 * Author: Inno Fang
 * Time: 2017/8/19 13:07
 * Description:
 */

@Route(path = "/pbs_sd_xinhua_fragment/1")
public class StudiesFragment extends BaseFragment {


    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    public static StudiesFragment newInstance() {
        return new StudiesFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.sd_fragment_studies;
    }

    @Override
    protected void createView(View view, Bundle savedInstanceState) {
        mViewPager = (ViewPager) find(R.id.sd_view_pager);
        mTabLayout = (TabLayout) find(R.id.sd_tab_layout);
    }

    @Override
    protected void initEvent() {
        String[] titles = {
                getString(R.string.important_comments),
                getString(R.string.focus),
                getString(R.string.practice_and_implement)
        };

        StudiesViewPagerAdapter adapter = new StudiesViewPagerAdapter(getChildFragmentManager(), titles);

        adapter.addFragment(PageFragment.newInstance("http://www.xinhuanet.com/politics/liangxueyizuo/zypl.htm"));
        adapter.addFragment(PageFragment.newInstance("http://www.xinhuanet.com/politics/liangxueyizuo/jj.htm"));
        adapter.addFragment(PageFragment.newInstance("http://www.xinhuanet.com/politics/liangxueyizuo/jxls.htm"));

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
