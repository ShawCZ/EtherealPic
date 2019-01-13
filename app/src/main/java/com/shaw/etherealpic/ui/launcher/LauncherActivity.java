package com.shaw.etherealpic.ui.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.shaw.etherealpic.base.BaseActivity;
import com.shaw.etherealpic.main.MainActivity;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
public class LauncherActivity extends BaseActivity<LauncherContract.Presenter, LauncherFragment> {
    public static boolean NEED_LAUNCHER = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //need launcher page at first time;
        if (!NEED_LAUNCHER) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }
}
