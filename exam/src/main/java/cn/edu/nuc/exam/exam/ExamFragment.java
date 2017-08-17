package cn.edu.nuc.exam.exam;

import android.os.Bundle;

import cn.edu.nuc.exam.R;
import cn.edu.nuc.library.base.BaseFragment;

/**
 * Author: Inno Fang
 * Time: 2017/8/17 15:17
 * Description:
 */


public class ExamFragment extends BaseFragment{

    public static ExamFragment newInstance() {

        Bundle args = new Bundle();

        ExamFragment fragment = new ExamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.ex_fragment_exam;
    }

    @Override
    protected void createView(Bundle savedInstanceState) {

    }



}
