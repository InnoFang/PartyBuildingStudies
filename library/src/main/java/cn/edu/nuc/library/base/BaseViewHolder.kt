package cn.edu.nuc.library.base

import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * Author: Inno Fang
 * Time: 2017/8/14 15:21
 * Description:
 */

abstract class BaseViewHolder<T>(private val mItemView: View) : RecyclerView.ViewHolder(mItemView) {

    abstract fun bindHolder(model: T)

    fun find(@IdRes id: Int): View {
        return mItemView.findViewById(id)
    }

}