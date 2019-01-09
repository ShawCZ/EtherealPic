package com.shaw.etherealpic.model.source;

import com.shaw.etherealpic.model.bean.Pic;

import java.util.List;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
public interface PicDataSource {
	interface LoadTasksCallback {
		void onTasksLoaded(List<Pic> tasks);

		void onDataNotAvailable();
	}

	interface GetTaskCallback {
		void onTaskLoaded(Pic task);

		void onDataNotAvailable();
	}

}
