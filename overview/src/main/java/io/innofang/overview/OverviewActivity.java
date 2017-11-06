package io.innofang.overview;

import android.support.v4.app.Fragment;

import org.jetbrains.annotations.NotNull;

import cn.edu.nuc.library.base.FragmentContainerActivity;

public class OverviewActivity extends FragmentContainerActivity {

    @NotNull
    @Override
    protected Fragment createFragment() {
        return OverviewFragment.newInstance();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_overview;
    }

    @Override
    public int getFragmentContainerId() {
        return R.id.ov_fragment_container;
    }
}
