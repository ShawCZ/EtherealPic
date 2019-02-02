package com.shaw.etherealpic.base;

import android.app.Application;
import android.content.Context;

import com.shaw.core.app.Core;

/**
 * @author zch@geniatech.com
 * @date 2018/6/13 20:54
 */
public class App extends Application {
	private static Application mApplication;

	@Override
	public void onCreate() {
		super.onCreate();
		mApplication = this;
		Core.init(this)
				.configure();
	}

	public static Context getApplication() {
		return mApplication.getApplicationContext();
	}

}
