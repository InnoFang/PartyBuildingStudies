package cn.edu.nuc.partybuildingstudies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = "/pbs_main/1")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.exam_button -> { ARouter.getInstance().build("/pbs_exam/1").navigation() }
            R.id.ov_button   -> { ARouter.getInstance().build("/pbs_ov/1").navigation() }
            R.id.ps_button   -> { ARouter.getInstance().build("/pbs_ps/1").navigation() }
        }
    }
}
