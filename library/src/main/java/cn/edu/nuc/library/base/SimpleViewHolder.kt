package cn.edu.nuc.library.base

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cn.edu.nuc.library.extensions.inflateView

/**
 * Author: Inno Fang
 * Time: 2017/8/14 17:35
 * Description:
 */

open class SimpleViewHolder(val mItemView: View) : RecyclerView.ViewHolder(mItemView) {

    private val mViews = SparseArray<View>()

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun <T : SimpleViewHolder> getViewHolder(context: Context,
                                                 parent: ViewGroup,
                                                 @LayoutRes layoutId: Int): T
                = SimpleViewHolder(parent.inflateView(layoutId)) as T
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : View> getView(@IdRes id: Int): T {
        mViews.get(id)?.let {
            val child = mItemView.findViewById(id)
            mViews.put(id, child)
        }
        return mViews.get(id) as T
    }

    fun setText(@IdRes id: Int, text: String) {
        getView<TextView>(id).text = text
    }


    fun setTextColor(@IdRes id: Int, @ColorInt color: Int) {
        getView<TextView>(id).setTextColor(color)
    }

    fun setImageResource(@IdRes id: Int, @DrawableRes resId: Int) {
        getView<ImageView>(id).setImageResource(resId)
    }

    fun setImageDrawable(@IdRes id: Int, drawable: Drawable) {
        getView<ImageView>(id).setImageDrawable(drawable)
    }

    fun setBackgroundColor(@IdRes id: Int, @ColorInt color: Int) {
        getView<View>(id).setBackgroundColor(color)
    }

    fun setVisible(@IdRes id: Int, visible: Boolean) {
        getView<View>(id).visibility = if (visible) View.VISIBLE else View.GONE
    }

    fun setOnClickListener(viewId: Int, listener: View.OnClickListener) {
        getView<View>(viewId).setOnClickListener(listener)
    }

    fun setOnTouchListener(viewId: Int, listener: View.OnTouchListener) {
        getView<View>(viewId).setOnTouchListener(listener)
    }

    fun setOnLongClickListener(viewId: Int, listener: View.OnLongClickListener) {
        getView<View>(viewId).setOnLongClickListener(listener)
    }
}