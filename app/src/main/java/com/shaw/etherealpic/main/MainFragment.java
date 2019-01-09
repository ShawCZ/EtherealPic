package com.shaw.etherealpic.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.shaw.etherealpic.R;
import com.shaw.etherealpic.base.BaseFragment;
import com.shaw.etherealpic.di.ActivityScoped;

import javax.inject.Inject;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@ActivityScoped
public class MainFragment extends BaseFragment<MainContract.Presenter> implements MainContract.View {
	private static final String TAG = "MainFragment";

	@Inject
	public MainFragment() {
		// Requires empty public constructor
	}

	@Override
	public Object setLayout() {
		return R.layout.activity_main;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate: presenter = " + mPresenter);
	}

}
