package cn.edu.nuc.library.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;

/**
 * Author: Inno Fang
 * Time: 2017/8/17 17:50
 * Description:
 */

public class AssetsUtil {
    private static final String TAG = "AssetsUtil";

    public static String getTextFromAssets(Context context, String fileName) {
        String result = "";
        try {
            InputStream is = context.getAssets().open(fileName);
            int length = is.available();
            byte[]  buffer = new byte[length];
            is.read(buffer);
            result = new String(buffer, "utf8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Bitmap getImageFromAssets(Context context, String fileName) {
        Bitmap bitmap = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            if (is instanceof AssetManager.AssetInputStream) {
                Log.d(TAG, "is instanceof AssetInputStream");
            } else {
                Log.d(TAG, "is not instanceof AssetInputStream");
            }
            bitmap = BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
