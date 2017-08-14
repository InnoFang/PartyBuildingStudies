package cn.edu.nuc.library.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Author: Inno Fang
 * Time: 2017/8/14 14:50
 * Description:
 */

abstract class BaseFragment: Fragment() {

    protected lateinit var mView: View

    @LayoutRes
    protected abstract fun  getLayoutResId(): Int

    protected abstract fun createView(savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater!!.inflate(getLayoutResId(), container, false)
        createView(savedInstanceState)
        return mView
    }

}