package io.innofang.studies;

import android.support.v4.app.Fragment;

import org.jetbrains.annotations.NotNull;

import cn.edu.nuc.library.base.FragmentContainerActivity;

public class StudiesActivity extends FragmentContainerActivity {

    @NotNull
    @Override
    protected Fragment createFragment() {
        return StudiesFragment.newInstance();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.sd_activity_studies;
    }

    @Override
    public int getFragmentContainerId() {
        return R.id.sd_fragment_container;
    }
}
