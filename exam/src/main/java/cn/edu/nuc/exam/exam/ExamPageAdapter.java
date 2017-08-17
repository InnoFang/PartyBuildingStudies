package cn.edu.nuc.exam.exam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Inno Fang
 * Time: 2017/8/17 17:59
 * Description:
 */


public class ExamPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> list = new ArrayList<>();

    public ExamPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment) {
        list.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
