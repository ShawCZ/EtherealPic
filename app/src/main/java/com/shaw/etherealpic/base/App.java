package com.shaw.etherealpic.base;

import android.app.Application;
import android.content.Context;

import com.shaw.etherealpic.di.DaggerAppComponent;
import com.shaw.etherealpic.model.source.PicRepository;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * @author zch@geniatech.com
 * @date 2018/6/13 20:54
 */
public class App extends DaggerApplication {
	private static Application mApplication;
	@Inject
	PicRepository picRepository;

	@Override
	public void onCreate() {
		super.onCreate();
		mApplication = this;
	}

	@Override
	protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
		return DaggerAppComponent.builder().applcation(this).build();
	}

	public static Context getApplication() {
		return mApplication.getApplicationContext();
	}

	public PicRepository getTasksRepository() {
		return picRepository;
	}
}
