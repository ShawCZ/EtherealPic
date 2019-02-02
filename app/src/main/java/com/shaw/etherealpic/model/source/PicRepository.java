package com.shaw.etherealpic.model.source;


/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
public class PicRepository implements PicDataSource {

	private final PicDataSource mTasksRemoteDataSource;

	private final PicDataSource mTasksLocalDataSource;

	public PicRepository(PicDataSource mTasksRemoteDataSource,  PicDataSource mTasksLocalDataSource) {
		this.mTasksRemoteDataSource = mTasksRemoteDataSource;
		this.mTasksLocalDataSource = mTasksLocalDataSource;
	}
}
