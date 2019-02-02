package com.shaw.etherealpic.ui.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.shaw.core.activitys.ProxyActivity;
import com.shaw.core.delegates.ShawDelegate;
import com.shaw.etherealpic.ui.main.MainDelegate;

import androidx.annotation.Nullable;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
public class LauncherActivity extends ProxyActivity {
	public static boolean NEED_LAUNCHER = true;

	@Override
	public ShawDelegate setRootDelegate() {
		//need launcher page at first time;
		if (!NEED_LAUNCHER) {
			return new MainDelegate();
		}
		return new LauncherFragment();
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
	}
}
