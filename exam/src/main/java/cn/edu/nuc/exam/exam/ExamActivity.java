package cn.edu.nuc.exam.exam;

import android.support.v4.app.Fragment;

import org.jetbrains.annotations.NotNull;

import cn.edu.nuc.exam.R;
import cn.edu.nuc.library.base.FragmentContainerActivity;

/**
 * Author: Inno Fang
 * Time: 2017/8/17 15:44
 * Description:
 */


public class ExamActivity extends FragmentContainerActivity {
    @NotNull
    @Override
    protected Fragment createFragment() {
        return ExamFragment.newInstance();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.ex_activity_exam;
    }

    @Override
    public int getFragmentContainerId() {
        return R.id.ex_exam_fragment_container;
    }
}
