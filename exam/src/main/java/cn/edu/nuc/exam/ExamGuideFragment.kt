package cn.edu.nuc.exam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import cn.edu.nuc.exam.exam.ExamActivity
import cn.edu.nuc.library.base.BaseFragment
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * Author: Inno Fang
 * Time: 2017/8/17 15:51
 * Description:
 */

@Route(path = "/pbs_exam_fragment/1")
class ExamGuideFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.ex_fragment_guide_exam

    val btnStartExam by lazy { find<Button>(R.id.ex_start_exam_button) }

    override fun createView(savedInstanceState: Bundle?) {

        btnStartExam.setOnClickListener {
            startActivity(Intent(activity, ExamActivity::class.java))
        }
    }

    companion object {

        fun newInstance(): ExamGuideFragment {

            val args = Bundle()

            val fragment = ExamGuideFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
