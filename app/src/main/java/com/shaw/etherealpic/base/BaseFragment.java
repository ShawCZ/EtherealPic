package com.shaw.etherealpic.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
public abstract class BaseFragment<Presenter extends BaseContract.Presenter> extends DaggerFragment implements BaseContract.View {
	@Inject
	public Presenter mPresenter;

	private Unbinder mUnbinder = null;

	public abstract Object setLayout();

	public abstract void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView);

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		final View rootview;
		if (setLayout() instanceof Integer) {
			rootview = inflater.inflate((Integer) setLayout(), container, false);
		} else if (setLayout() instanceof View) {
			rootview = (View) setLayout();
		} else {
			throw new ClassCastException("setLayout() type must be int or View");
		}

		//使用ButterKnife绑定视图
		mUnbinder = ButterKnife.bind(this, rootview);
		onBindView(savedInstanceState, rootview);
		mPresenter.setView(this);
		return rootview;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		// 界面关闭时进行销毁的操作
		if (mPresenter != null) {
			mPresenter.unSubscribe();
		}
		if (mUnbinder != null) {
			mUnbinder.unbind();
		}
	}


	@Override
	public void showLoading(String message) {

	}

	@Override
	public void stopLoading() {

	}
}
