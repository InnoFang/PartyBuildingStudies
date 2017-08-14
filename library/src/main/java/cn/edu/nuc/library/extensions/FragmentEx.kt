package cn.edu.nuc.library.extensions

import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Author: Inno Fang
 * Time: 2017/8/14 14:48
 * Description:
 */

//inline fun <reified T : View> Fragment.find(@IdRes id: Int): T = view?.findViewById(id) as T

fun Fragment.toast(resId: Int, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(activity, resId, duration).show()

fun Fragment.toast(text: String = "", time: Int = Toast.LENGTH_SHORT) = Toast.makeText(activity, text, time).show()