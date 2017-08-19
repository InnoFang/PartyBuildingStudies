package cn.edu.nuc.library.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: Inno Fang
 * Time: 2017/8/19 12:15
 * Description:
 */


public abstract class BaseFragment extends Fragment {


    protected View mView;

    @LayoutRes
    protected abstract int getLayoutResId();

    protected abstract void createView(View view, Bundle savedInstanceState);

    protected abstract void initEvent();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutResId(), container, false);
        createView(mView, savedInstanceState);
        initEvent();
        return mView;
    }

    public View find(@IdRes int id) {
        return mView.findViewById(id);
    }


}