package com.shaw.etherealpic.ui.launcher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.shaw.etherealpic.R;
import com.shaw.etherealpic.base.BaseFragment;
import com.shaw.etherealpic.di.ActivityScoped;
import com.shaw.etherealpic.main.MainContract;
import com.shaw.etherealpic.ui.launcher.launcher.LauncherHolderCreator;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@ActivityScoped
public class LauncherFragment extends BaseFragment<LauncherContract.Presenter> implements LauncherContract.View, OnItemClickListener {
	private static final String TAG = "MainFragment";
	private ConvenientBanner<Integer> mConvenientBanner = null;
	private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

	@Inject
	public LauncherFragment() {
		// Requires empty public constructor
	}

	@Override
	public Object setLayout() {
		mConvenientBanner = new ConvenientBanner<>(getContext());
		return mConvenientBanner;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
		Log.d(TAG, "onCreate: presenter = " + mPresenter);
		Toast.makeText(getActivity(), "~~~~~~~~~~", Toast.LENGTH_SHORT).show();
		initBanner();
	}

	private void initBanner() {
		INTEGERS.add(R.drawable.banner0);
		INTEGERS.add(R.drawable.banner1);
		INTEGERS.add(R.drawable.banner0);
		INTEGERS.add(R.drawable.banner1);

		mConvenientBanner
				.setPages(new LauncherHolderCreator(), INTEGERS)
				.setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
				.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
				.setOnItemClickListener(this)
				.setCanLoop(false);
	}

	@Override
	public void onItemClick(int position) {
		Log.d(TAG, "onItemClick: postion = " + position);
	}
}
