package com.shaw.etherealpic.di;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@Module
public abstract class ApplicationModule {
	@Binds
	abstract Context bindContext(Application application);
}
