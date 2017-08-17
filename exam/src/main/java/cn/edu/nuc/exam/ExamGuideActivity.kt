package cn.edu.nuc.exam

import android.support.v4.app.Fragment
import cn.edu.nuc.library.base.FragmentContainerActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/pbs_exam/1")
class ExamGuideActivity : FragmentContainerActivity() {

    override fun createFragment(): Fragment = ExamGuideFragment.newInstance()

    override val layoutResId: Int = R.layout.ex_activity

    override val fragmentContainerId: Int = R.id.ex_fragment_container

}
