package cn.edu.nuc.partybuildingstudies;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Author: Inno Fang
 * Time: 2017/8/27 14:46
 * Description:
 */


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openDebug();
        }

        ARouter.init(this);
    }
}
