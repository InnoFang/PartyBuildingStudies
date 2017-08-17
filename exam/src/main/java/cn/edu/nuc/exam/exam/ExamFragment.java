package cn.edu.nuc.exam.exam;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.gson.Gson;

import cn.edu.nuc.exam.R;
import cn.edu.nuc.exam.exam.question.QuestionFragment;
import cn.edu.nuc.library.base.BaseFragment;
import cn.edu.nuc.library.utils.AssetsUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: Inno Fang
 * Time: 2017/8/17 15:17
 * Description:
 */


public class ExamFragment extends BaseFragment {

    private SeekBar mQuestiuonNumberSeekbar;
    private TextView mQuestiuonNumberTextView;
    private ViewPager mQuestionViewPager;

    private ExamPageAdapter mAdapter;

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

        mQuestiuonNumberSeekbar = (SeekBar) mView.findViewById(R.id.question_number_seek_bar);
        mQuestiuonNumberTextView = (TextView) mView.findViewById(R.id.question_number_text_view);
        mQuestionViewPager = (ViewPager) mView.findViewById(R.id.question_view_pager);

        init();
    }

    private void init() {
        Observable.create(new ObservableOnSubscribe<Question>() {
            @Override
            public void subscribe(ObservableEmitter<Question> e) throws Exception {
                String json = AssetsUtil.getTextFromAssets(getActivity(), "exam.txt");
                Question question = new Gson().fromJson(json, Question.class);
                e.onNext(question);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Question>() {
                    @Override
                    public void accept(@NonNull Question question) throws Exception {
                        init(question);
                    }
                });
    }

    private void init(Question question) {
        final int max = question.getSubject().size();
        mQuestiuonNumberSeekbar.setMax(max);
        mQuestiuonNumberTextView.setText(getString(R.string.ex_question_number, 1, max));
        mQuestiuonNumberSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("tag", progress + "");
                mQuestiuonNumberTextView.setText(getString(R.string.ex_question_number, progress + 1, max));
                mQuestionViewPager.setCurrentItem(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mAdapter = new ExamPageAdapter(getChildFragmentManager());

        for (int i = 0; i < max; i++) {
            mAdapter.addFragment(QuestionFragment.newInstance(question.getSubject().get(i)));
        }

        mQuestionViewPager.setAdapter(mAdapter);
        mQuestionViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mQuestiuonNumberTextView.setText(getString(R.string.ex_question_number, position + 1, max));

                if (Build.VERSION.SDK_INT >= 24) {
                    mQuestiuonNumberSeekbar.setProgress(position, true);
                } else {
                    mQuestiuonNumberSeekbar.setProgress(position);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
