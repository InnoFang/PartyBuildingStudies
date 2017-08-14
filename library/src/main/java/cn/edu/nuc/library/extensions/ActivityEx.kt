package cn.edu.nuc.library.extensions

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

/**
 * Author: Inno Fang
 * Time: 2017/8/14 14:48
 * Description:
 */

inline fun <reified T : View> Activity.find(@IdRes id: Int): T = findViewById(id) as T