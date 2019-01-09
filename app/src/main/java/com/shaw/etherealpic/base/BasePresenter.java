package com.shaw.etherealpic.base;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter<T> {
	public final String TAG = this.getClass().getSimpleName();

	private T mView;
	public final CompositeDisposable DISPOSABLES;

	public BasePresenter() {
		DISPOSABLES = new CompositeDisposable();
	}

	/**
	 * 给子类使用的获取View的操作
	 * 不允许复写
	 *
	 * @return View
	 */
	protected final T getView() {
		return mView;
	}

	@Override
	public void subscribe() {
		// 开始的时候进行Loading调用
		T view = mView;
		if (view != null) {
			view.showLoading(null);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void unSubscribe() {
		T view = mView;
		mView = null;
		DISPOSABLES.clear();
	}

	@Override
	public void setView(T view) {
		this.mView = view;
	}
}
