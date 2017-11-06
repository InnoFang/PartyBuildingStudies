package cn.edu.nuc.partybuildingstudies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nuc.exam.ExamGuideFragment;
import cn.edu.nuc.popularscience.PopularScienceFragment;
import io.innofang.overview.OverviewFragment;
import io.innofang.studies.StudiesFragment;

/**
 * Author: Inno Fang
 * Time: 2017/8/18 22:13
 * Description:
 */


public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private MenuItem mMenuItem;
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_overview:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.item_studies:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.item_popular_science:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.item_exam:
                        mViewPager.setCurrentItem(3);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (null != mMenuItem) {
                    mMenuItem.setChecked(false);
                } else {
                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                mMenuItem = mBottomNavigationView.getMenu().getItem(position);
                mMenuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        List<Fragment> list = new ArrayList<>();
//        Fragment fragment = (Fragment) ARouter.getInstance().build("/pbs_ov_fragment/1").navigation();
//        if (fragment == null) {
//            Toast.makeText(this, "IS NULL", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "IS NOT NULL", Toast.LENGTH_SHORT).show();
//        }

        /*list.add((Fragment) ARouter.getInstance().build("/pbs_ov_fragment/1").navigation());
        list.add((Fragment) ARouter.getInstance().build("/pbs_sd_fragment/1").navigation());
        list.add((Fragment) ARouter.getInstance().build("/pbs_ps_fragment/1").navigation());
        list.add((Fragment) ARouter.getInstance().build("/pbs_exam_fragment/1").navigation());
*/
        list.add(OverviewFragment.newInstance());
        list.add(StudiesFragment.newInstance());
        list.add(PopularScienceFragment.newInstance());
        list.add(ExamGuideFragment.newInstance());

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
        mViewPager.setAdapter(adapter);
    }
}
