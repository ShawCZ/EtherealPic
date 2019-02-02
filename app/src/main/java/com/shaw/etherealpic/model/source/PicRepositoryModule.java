package com.shaw.etherealpic.model.source;

import com.shaw.etherealpic.model.source.local.PicLocalDataSource;
import com.shaw.etherealpic.model.source.remote.PicRemoteDataSource;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
public abstract class PicRepositoryModule {

	abstract PicDataSource providePicLocalDataSource(PicLocalDataSource dataSource);

	abstract PicDataSource providePicRemoteDataSource(PicRemoteDataSource dataSource);
}
