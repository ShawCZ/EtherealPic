package com.shaw.etherealpic.model.source;

import javax.inject.Inject;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
public class PicRepository implements PicDataSource {

	private final PicDataSource mTasksRemoteDataSource;

	private final PicDataSource mTasksLocalDataSource;

	@Inject
	public PicRepository(@Remote PicDataSource mTasksRemoteDataSource, @Local PicDataSource mTasksLocalDataSource) {
		this.mTasksRemoteDataSource = mTasksRemoteDataSource;
		this.mTasksLocalDataSource = mTasksLocalDataSource;
	}
}
