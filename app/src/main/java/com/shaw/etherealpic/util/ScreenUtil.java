package com.shaw.etherealpic.util;

import android.content.Context;
import android.content.res.Resources;

/**
 * Author by Shaw on 2019/1/13 16:12
 */
public class ScreenUtil {

    //获取虚拟按键的高度
    public static int getNavigationBarHeight(Context context) {
        int result = 0;
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
