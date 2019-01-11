package com.shaw.etherealpic.ui.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.shaw.etherealpic.base.BaseActivity;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
public class LauncherActivity extends BaseActivity<LauncherContract.Presenter, LauncherFragment> {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
	}
}
