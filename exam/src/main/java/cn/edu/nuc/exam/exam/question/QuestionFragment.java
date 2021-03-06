package cn.edu.nuc.exam.exam.question;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import cn.edu.nuc.exam.R;
import cn.edu.nuc.exam.exam.Question;
import cn.edu.nuc.library.base.BaseFragment;

/**
 * Author: Inno Fang
 * Time: 2017/8/17 17:55
 * Description:
 */


public class QuestionFragment extends BaseFragment implements RadioButton.OnCheckedChangeListener {

    private static final String ARG_QUESTION = "question";

    private Question.SubjectBean mQuestion;

    private TextView mQuestionTextView;
    private RadioButton mARadioButton;
    private RadioButton mBRadioButton;
    private RadioButton mCRadioButton;
    private RadioButton mDRadioButton;
    private TextView mResultTextView;

    public static QuestionFragment newInstance(Question.SubjectBean bean) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_QUESTION, bean);
        QuestionFragment fragment = new QuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ex_fragment_question_item;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQuestion = (Question.SubjectBean) getArguments().getSerializable(ARG_QUESTION);
    }

    @Override
    protected void createView(View view, Bundle savedInstanceState) {
        mQuestionTextView = (TextView) find(R.id.question_text_view);
        mARadioButton = (RadioButton) find(R.id.answer_a_radio_button);
        mBRadioButton = (RadioButton) find(R.id.answer_b_radio_button);
        mCRadioButton = (RadioButton) find(R.id.answer_c_radio_button);
        mDRadioButton = (RadioButton) find(R.id.answer_d_radio_button);
        mResultTextView = (TextView) find(R.id.result_text_view);

    }

    @Override
    protected void initEvent() {
        mQuestionTextView.setText(mQuestion.getQuestion());
        mARadioButton.setText(mQuestion.getA());
        mBRadioButton.setText(mQuestion.getB());
        mCRadioButton.setText(mQuestion.getC());
        if (TextUtils.isEmpty(mQuestion.getD())) {
            mDRadioButton.setVisibility(View.GONE);
        } else {
            mDRadioButton.setText(mQuestion.getD());
            mDRadioButton.setOnCheckedChangeListener(this);
        }

        mARadioButton.setOnCheckedChangeListener(this);
        mBRadioButton.setOnCheckedChangeListener(this);
        mCRadioButton.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            if (buttonView.getText().equals(mQuestion.getAnswer())) {
                mResultTextView.setText(getString(R.string.ex_right));
                mResultTextView.setTextColor(Color.GREEN);
            } else {
                mResultTextView.setText(getString(R.string.ex_wrong, mQuestion.getAnswer()));
                mResultTextView.setTextColor(Color.RED);
            }
        }
    }
}
