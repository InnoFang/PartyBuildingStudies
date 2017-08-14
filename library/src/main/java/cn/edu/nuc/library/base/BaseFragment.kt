package cn.edu.nuc.library.base

import android.os.Bundle
import android.support.annotation.IdRes
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

    @get:LayoutRes
    abstract val layoutResId: Int

    protected abstract fun createView(savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater!!.inflate(layoutResId, container, false)
        createView(savedInstanceState)
        return mView
    }

    inline fun <reified T : View> Fragment.find(@IdRes id: Int): T = mView.findViewById(id) as T
}