package com.shaw.etherealpic.model.source;

import com.shaw.etherealpic.model.source.local.PicLocalDataSource;
import com.shaw.etherealpic.model.source.remote.PicRemoteDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@Module
public abstract class PicRepositoryModule {
	@Singleton
	@Binds
	@Local
	abstract PicDataSource providePicLocalDataSource(PicLocalDataSource dataSource);

	@Singleton
	@Binds
	@Remote
	abstract PicDataSource providePicRemoteDataSource(PicRemoteDataSource dataSource);
}
