package cn.edu.nuc.exam

import android.os.Bundle
import android.widget.Button
import cn.edu.nuc.exam.exam.ExamFragment

import cn.edu.nuc.library.base.BaseFragment

/**
 * Author: Inno Fang
 * Time: 2017/8/17 14:58
 * Description:
 */


class ExamGuideFragment : BaseFragment() {

    companion object {
        fun newInstance(): ExamGuideFragment = ExamGuideFragment()
    }

    override val layoutResId: Int = R.layout.ex_fragment

    val btnStartExam by lazy { find<Button>(R.id.ex_start_exam_button) }

    override fun createView(savedInstanceState: Bundle?) {
        btnStartExam.setOnClickListener {
            (activity as ExamGuideActivity).switchFragment(ExamFragment.newInstance())
        }
    }
}
