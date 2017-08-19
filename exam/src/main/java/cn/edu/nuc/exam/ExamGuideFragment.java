package cn.edu.nuc.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.edu.nuc.exam.exam.ExamActivity;
import cn.edu.nuc.library.base.BaseFragment;

/**
 * Author: Inno Fang
 * Time: 2017/8/19 12:21
 * Description:
 */

@Route(path = "/pbs_exam_fragment/1")
public class ExamGuideFragment extends BaseFragment {

    public static ExamGuideFragment newInstance() {
        return new ExamGuideFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ex_fragment_guide_exam;
    }

    private Button mStartExamButton;

    @Override
    protected void createView(View view, Bundle savedInstanceState) {
        mStartExamButton = (Button) find(R.id.ex_start_exam_button);
    }

    @Override
    protected void initEvent() {
        mStartExamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ExamActivity.class));
            }
        });
    }
}
