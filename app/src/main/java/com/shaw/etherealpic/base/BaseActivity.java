package com.shaw.etherealpic.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.shaw.etherealpic.R;
import com.shaw.etherealpic.util.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.DaggerFragment;

/**
 * @author xcz
 * @version 1.0.0
 */
public abstract class BaseActivity<Presenter extends BaseContract.Presenter, FragmentProvider extends DaggerFragment>
		extends DaggerAppCompatActivity {
	public final String TAG = getClass().getSimpleName();

	@Inject
	public Presenter mPresenter;

	@Inject
	public Lazy<FragmentProvider> mFragmentProvider;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final FrameLayout container = new FrameLayout(this);
		container.setId(R.id.delegate_container);
		setContentView(container);
		if (savedInstanceState == null) {
			ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mFragmentProvider.get(), R.id.delegate_container);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.gc();
		System.runFinalization();
	}
}
