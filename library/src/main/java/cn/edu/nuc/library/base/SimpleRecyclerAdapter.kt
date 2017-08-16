package cn.edu.nuc.library.base

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.*

/**
 * Author: Inno Fang
 * Time: 2017/8/14 17:34
 * Description:
 */

abstract class SimpleRecyclerAdapter<T>
constructor(val mContext: Context,
            @LayoutRes val id: Int,
            var mList: ArrayList<T>) : RecyclerView.Adapter<SimpleViewHolder>() {

    fun addItem(t: T) {
        mList.add(t)
        notifyItemInserted(mList.size - 1)
    }

    fun delItem(t: T) {
        val pos = mList.indexOf(t)
        if (-1 != pos) {
            mList.removeAt(pos)
            notifyItemRemoved(pos)
        }
    }

    fun resetItem(list: ArrayList<T>) {
        mList.clear()
        mList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SimpleViewHolder
        = SimpleViewHolder.getViewHolder(mContext, parent!!, id)

    abstract fun bindViewHolder(viewHolder: SimpleViewHolder, t: T, pos: Int)

    override fun onBindViewHolder(holder: SimpleViewHolder?, position: Int) {
        bindViewHolder(holder!!, mList[position], position)
    }

    override fun getItemCount(): Int = mList.size
}