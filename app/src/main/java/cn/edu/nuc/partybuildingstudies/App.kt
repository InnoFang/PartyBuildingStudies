package cn.edu.nuc.partybuildingstudies

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Author: Inno Fang
 * Time: 2017/8/14 11:50
 * Description:
 */

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this);
    }

}