package com.shaw.etherealpic.di;


import com.shaw.etherealpic.main.MainActivity;
import com.shaw.etherealpic.main.MainModule;
import com.shaw.etherealpic.ui.launcher.LauncherActivity;
import com.shaw.etherealpic.ui.launcher.LauncherModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@Module
public abstract class ActivityBindingModule {
	@ActivityScoped
	@ContributesAndroidInjector(modules = MainModule.class)
	abstract MainActivity mainActivity();

	@ActivityScoped
	@ContributesAndroidInjector(modules = LauncherModule.class)
	abstract LauncherActivity launcherActivity();
}
