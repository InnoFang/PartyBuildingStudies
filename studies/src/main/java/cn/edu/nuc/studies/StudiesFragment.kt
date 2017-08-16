package cn.edu.nuc.studies

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import cn.edu.nuc.library.base.BaseFragment
import cn.edu.nuc.studies.page.PageFragment

/**
 * Author: Inno Fang
 * Time: 2017/8/15 10:15
 * Description:
 */

class StudiesFragment : BaseFragment() {

    companion object {
        fun newInstance(): StudiesFragment = StudiesFragment()
    }

    override val layoutResId: Int = R.layout.sd_fragment_studies

    private val mViewPager by lazy { find<ViewPager>(R.id.sd_view_pager) }
    private val mTabLayout by lazy { find<TabLayout>(R.id.sd_tab_layout) }

    override fun createView(savedInstanceState: Bundle?) {

        val titles = arrayOf(
                getString(R.string.sd_learning_and_discussion),
                getString(R.string.sd_hot_spot_review),
                getString(R.string.sd_advanced_model)
        )

        val vpAdapter = StudiesViewPagerAdapter(childFragmentManager, titles)

        vpAdapter.addFragment(PageFragment.newInstance("http://www.gapp.gov.cn/ztzzd/rdztl/lxyz/channels/6564.shtml"))
        vpAdapter.addFragment(PageFragment.newInstance("http://www.gapp.gov.cn/ztzzd/rdztl/lxyz/channels/6566.shtml"))
        vpAdapter.addFragment(PageFragment.newInstance("http://www.gapp.gov.cn/ztzzd/rdztl/lxyz/channels/6570.shtml"))

        mViewPager.adapter = vpAdapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

}