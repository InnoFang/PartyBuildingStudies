package cn.edu.nuc.partybuildingstudies;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Author: Inno Fang
 * Time: 2017/8/17 14:28
 * Description:
 */


public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DISPLAY_TIME = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Intent intent = new Intent(this, DeActivity.class);
//        startActivity(intent);
//        finish();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_TIME);
    }
}
