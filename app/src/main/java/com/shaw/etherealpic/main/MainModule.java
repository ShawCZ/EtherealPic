package com.shaw.etherealpic.main;

import com.shaw.etherealpic.di.ActivityScoped;
import com.shaw.etherealpic.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@Module
public abstract class MainModule {

	@FragmentScoped
	@ContributesAndroidInjector
	abstract MainFragment mainFragment();

	@ActivityScoped
	@Binds
	abstract MainContract.Presenter presenter(MainPresenter presenter);
}
