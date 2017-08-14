package cn.edu.nuc.library.extensions

import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Author: Inno Fang
 * Time: 2017/8/14 14:49
 * Description:
 */

inline fun <reified T : View> View.find(@IdRes id: Int): T = findViewById(id) as T

fun ViewGroup.inflateView(@LayoutRes id: Int): View = LayoutInflater.from(context).inflate(id, this, false)

