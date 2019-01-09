package com.shaw.etherealpic.di;

import android.app.Application;

import com.shaw.etherealpic.base.App;
import com.shaw.etherealpic.model.source.PicRepository;
import com.shaw.etherealpic.model.source.PicRepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@Singleton
@Component(modules = {
		PicRepositoryModule.class,
		ApplicationModule.class,
		ActivityBindingModule.class,
		AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<App> {
	PicRepository picRepository();

	@Component.Builder
	interface Builder {
		@BindsInstance
		Builder applcation(Application application);

		AppComponent build();
	}
}
