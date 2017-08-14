package cn.edu.nuc.popularscience

import android.support.v4.app.Fragment
import cn.edu.nuc.library.base.FragmentContainerActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/pbs_ps/1")
class PopularScienceActivity : FragmentContainerActivity() {

    override val layoutResId: Int = R.layout.ps_activity

    override val fragmentContainerId: Int = R.id.ps_fragment_container

    override fun createFragment(): Fragment = PopularScienceFragment.newInstance()

}
