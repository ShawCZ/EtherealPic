package com.shaw.etherealpic.ui.launcher;

import com.shaw.etherealpic.di.ActivityScoped;
import com.shaw.etherealpic.di.FragmentScoped;
import com.shaw.etherealpic.main.MainContract;
import com.shaw.etherealpic.main.MainFragment;
import com.shaw.etherealpic.main.MainPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@Module
public abstract class LauncherModule {

	@FragmentScoped
	@ContributesAndroidInjector
	abstract LauncherFragment fragment();

	@FragmentScoped
	@ContributesAndroidInjector
	abstract LauncherScrollFragment scrollFragment();

	@ActivityScoped
	@Binds
	abstract LauncherContract.Presenter presenter(LauncherPresenter presenter);
}
