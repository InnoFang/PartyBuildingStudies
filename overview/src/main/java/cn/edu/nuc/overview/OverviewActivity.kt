package cn.edu.nuc.overview

import android.support.v4.app.Fragment
import cn.edu.nuc.library.base.FragmentContainerActivity

class OverviewActivity : FragmentContainerActivity() {

    override val layoutResId = R.layout.ov_activity

    override val fragmentContainerId: Int = R.id.ov_fragment_container

    override fun createFragment(): Fragment = OverviewFragment.newInstance()

}
