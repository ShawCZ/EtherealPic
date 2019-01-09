package com.shaw.etherealpic.base;

/**
 * Created on 2018/12/8.
 *
 * @author XCZ
 */
public interface BaseContract {
	interface View {
		// 公共的：显示进度条
		void showLoading(String message);

		// 公共的：关闭进度条
		void stopLoading();
	}

	interface Presenter<T extends View> {
		//开始订阅
		void subscribe();

		//取消订阅
		void unSubscribe();

		void setView(T view);
	}
}
