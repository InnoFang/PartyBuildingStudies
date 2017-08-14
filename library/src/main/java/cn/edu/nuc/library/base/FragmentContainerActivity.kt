package cn.edu.nuc.library.base

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager


/**
 * Author: Inno Fang
 * Time: 2017/8/14 15:12
 * Description:
 */

abstract class FragmentContainerActivity: BaseActivity() {

    private lateinit var mFragmentManager: FragmentManager
    private var mCurrentFragment: Fragment? = null

    /**
     * 创建 Fragment 实例

     * @return 需要托管的 Fragment 实例
     */
    protected abstract fun createFragment(): Fragment

    /**
     * 获得托管 Fragment 的布局文件 Id

     * @return 托管 Fragment 的布局文件 Id
     */
    @LayoutRes
    protected abstract fun getLayoutResId(): Int

    /**
     * 获得托管 Fragment 的 View 的 Id

     * @return 托管 Fragment 的 View 的 Id
     */
    @IdRes
    protected abstract fun getFragmentContainerId(): Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())

        mFragmentManager = supportFragmentManager
        mCurrentFragment = mFragmentManager.findFragmentById(getFragmentContainerId())

        if (null == mCurrentFragment) {
            mCurrentFragment = createFragment()
            mFragmentManager.beginTransaction()
                    .add(getFragmentContainerId(), mCurrentFragment)
                    .commit()
        }
    }

    /**
     * 转换Fragment
     * 首先当前存在Fragment，并且当前Fragment不是要转换的Fragment，避免重复操作
     * @param fragment 需要转换的Fargment
     */
    fun switchFragment(fragment: Fragment) {
        if (mCurrentFragment == null
                || fragment::class.java.name != (mCurrentFragment!!::class.java.name)) {
            val fragmentTransaction = mFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in,
                            android.R.anim.fade_out)
            if (!fragment.isAdded) { // 检查 fragment 是否被添加
                // 隐藏当前 mCurrentFragment，add fragment 到 Activity 中
                fragmentTransaction
                        .hide(mCurrentFragment)
                        .add(getFragmentContainerId(), fragment)
                        .commit()
                mCurrentFragment = fragment
            } else {
                // 隐藏当前 mCurrentFragment，显示 fragment
                fragmentTransaction
                        .hide(mCurrentFragment)
                        .show(fragment)
                        .commit()
                mCurrentFragment = fragment
            }
        }
    }
}