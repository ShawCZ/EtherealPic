package com.shaw.etherealpic.ui.launcher;

import com.shaw.core.mvp.BasePresenter;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
public class LauncherPresenter extends BasePresenter<LauncherContract.View> implements LauncherContract.Presenter {
	public LauncherPresenter(LauncherContract.View view) {
		super(view);
	}
}
