package cn.edu.nuc.overview

import android.support.v4.app.Fragment
import cn.edu.nuc.library.base.FragmentContainerActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/pbs_ov/1")
class OverviewActivity : FragmentContainerActivity() {

    override val layoutResId = R.layout.ov_activity

    override val fragmentContainerId: Int = R.id.ov_fragment_container

    override fun createFragment(): Fragment = OverviewFragment.newInstance()

}
