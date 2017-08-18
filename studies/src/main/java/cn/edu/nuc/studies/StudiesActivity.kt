package cn.edu.nuc.studies

import android.support.v4.app.Fragment
import cn.edu.nuc.library.base.FragmentContainerActivity


class StudiesActivity : FragmentContainerActivity() {

    override val layoutResId: Int = R.layout.sd_activity_studies

    override val fragmentContainerId: Int = R.id.sd_fragment_container

    override fun createFragment(): Fragment = StudiesFragment.newInstance()

}
