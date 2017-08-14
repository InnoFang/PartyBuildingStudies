package cn.edu.nuc.library.extensions

import android.content.Context
import android.widget.Toast

/**
 * Author: Inno Fang
 * Time: 2017/8/14 14:49
 * Description:
 */

fun Context.toast(resId: Int, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, resId, duration).show()

fun Context.toast(text: String = "", time: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, text, time).show()