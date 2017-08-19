package cn.edu.nuc.studies;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.edu.nuc.library.base.BaseFragment;
import cn.edu.nuc.studies.page.PageFragment;

/**
 * Author: Inno Fang
 * Time: 2017/8/19 13:07
 * Description:
 */

@Route(path = "/pbs_sd_fragment/1")
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
                getString(R.string.sd_learning_and_discussion),
                getString(R.string.sd_hot_spot_review),
                getString(R.string.sd_advanced_model)
        };

        StudiesViewPagerAdapter adapter = new StudiesViewPagerAdapter(getChildFragmentManager(), titles);

        adapter.addFragment(PageFragment.newInstance("http://www.gapp.gov.cn/ztzzd/rdztl/lxyz/channels/6564.shtml"));
        adapter.addFragment(PageFragment.newInstance("http://www.gapp.gov.cn/ztzzd/rdztl/lxyz/channels/6566.shtml"));
        adapter.addFragment(PageFragment.newInstance("http://www.gapp.gov.cn/ztzzd/rdztl/lxyz/channels/6570.shtml"));

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
