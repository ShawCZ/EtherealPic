package com.shaw.etherealpic.main;

import android.util.Log;

import com.shaw.etherealpic.base.BasePresenter;
import com.shaw.etherealpic.di.ActivityScoped;
import com.shaw.etherealpic.model.source.PicRepository;

import javax.inject.Inject;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@ActivityScoped
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
	@Inject
	public MainPresenter(PicRepository repository) {
	}

	@Override
	public void subscribe() {
		Log.d(TAG, "MainPresenter: view = " + getView());
	}

	@Override
	public void unSubscribe() {

	}
}
