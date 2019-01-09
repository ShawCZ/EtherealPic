package com.shaw.etherealpic.ui.launcher;

import android.util.Log;

import com.shaw.etherealpic.base.BasePresenter;
import com.shaw.etherealpic.di.ActivityScoped;
import com.shaw.etherealpic.main.MainContract;
import com.shaw.etherealpic.model.source.PicRepository;

import javax.inject.Inject;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@ActivityScoped
public class LauncherPresenter extends BasePresenter<LauncherContract.View> implements LauncherContract.Presenter {
	@Inject
	public LauncherPresenter(PicRepository repository) {
	}

	@Override
	public void subscribe() {
		Log.d(TAG, "MainPresenter: view = " + getView());
	}

	@Override
	public void unSubscribe() {

	}


}
