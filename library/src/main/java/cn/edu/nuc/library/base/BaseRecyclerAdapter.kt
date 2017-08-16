package cn.edu.nuc.library.base

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import cn.edu.nuc.library.extensions.inflateView
import org.jetbrains.annotations.NotNull

/**
 * Author: Inno Fang
 * Time: 2017/8/14 15:21
 * Description:
 */

abstract class BaseRecyclerAdapter<VH : BaseViewHolder<L>, L : Any>
@JvmOverloads
constructor(protected var mContext: Context, protected var mList: java.util.ArrayList<L> = ArrayList<L>(0))
    : RecyclerView.Adapter<VH>() {

    @get:LayoutRes
    abstract val itemLayoutResId: Int

    @NotNull
    abstract fun createViewHolder(parent: ViewGroup, viewType: Int, view: View): RecyclerView.ViewHolder

    fun getList(): List<L>? {
        return mList
    }

    fun setList(list: List<L>) {
        mList = list as java.util.ArrayList<L>
        notifyDataSetChanged()
    }

    fun addItem(l: L) {
        mList.add(l)
        notifyItemInserted(mList.size - 1)
    }

    fun delItem(l: L) {
        val pos = mList.indexOf(l)
        if (-1 != pos) {
            mList.removeAt(pos)
            notifyItemRemoved(pos)
        }
    }

    fun resetItem(list: ArrayList<L>) {
        mList.clear()
        list.map { mList.add(it) }
        notifyDataSetChanged()
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
       val view =  parent!!.inflateView(itemLayoutResId)
        return createViewHolder(parent, viewType, view) as VH
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindHolder(mList[position])
    }

    override fun getItemCount(): Int = mList.size
}