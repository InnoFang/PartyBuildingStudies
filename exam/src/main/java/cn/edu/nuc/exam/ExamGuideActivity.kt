package cn.edu.nuc.exam

import android.support.v4.app.Fragment
import cn.edu.nuc.library.base.FragmentContainerActivity

/**
 * Author: Inno Fang
 * Time: 2017/8/17 15:51
 * Description:
 */


class ExamGuideActivity : FragmentContainerActivity() {

    override fun createFragment(): Fragment = ExamGuideFragment.newInstance()

    override val layoutResId: Int = R.layout.ex_activity_guide_exam

    override val fragmentContainerId: Int = R.id.ex_guide_exam_fragment_container
}
