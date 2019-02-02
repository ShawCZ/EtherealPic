package com.shaw.etherealpic.ui.launcher;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.shaw.core.mvp.PresenterDelegate;
import com.shaw.core.util.storage.LattePreference;
import com.shaw.etherealpic.R;
import com.shaw.etherealpic.ui.launcher.launcher.LauncherHolderCreator;
import com.shaw.etherealpic.ui.main.MainDelegate;
import com.shaw.etherealpic.util.ScreenUtil;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;


/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
public class LauncherScrollFragment extends PresenterDelegate<LauncherContract.Presenter> implements LauncherContract.View, ViewPager.OnPageChangeListener {
	private ConvenientBanner<Integer> mConvenientBanner = null;
	private TextView tvNext = null;
	private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

	public LauncherScrollFragment() {
		// Requires empty public constructor
	}

	@Override
	public Object setLayout() {
		mConvenientBanner = new ConvenientBanner<>(getContext());
		return mConvenientBanner;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
		initBanner();
		initNextButton();
	}

	private void initNextButton() {
		tvNext = new TextView(getActivity());
		tvNext.setVisibility(View.GONE);
		tvNext.setText("Next");
		tvNext.setTextColor(Color.WHITE);
		tvNext.setBackgroundResource(R.drawable.shape_bg_tv);
		tvNext.setPadding(30, 5, 30, 5);

		FrameLayout parent = (FrameLayout) getActivity().getWindow().getDecorView().getRootView();
		parent.addView(tvNext);

		FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) tvNext.getLayoutParams();
		params.gravity = Gravity.BOTTOM | Gravity.END;
		params.rightMargin = 60;
		params.bottomMargin = ScreenUtil.getNavigationBarHeight(getContext()) + 40;
		params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
		params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
		tvNext.setGravity(Gravity.CENTER);
		tvNext.setLayoutParams(params);
		tvNext.setOnClickListener(v -> clickNext());
		tvNext.setFocusable(true);
		tvNext.setClickable(true);
		tvNext.setFocusableInTouchMode(true);
	}

	private void initBanner() {
		INTEGERS.clear();
		INTEGERS.add(R.drawable.banner0);
		INTEGERS.add(R.drawable.banner1);
		INTEGERS.add(R.drawable.banner0);
		INTEGERS.add(R.drawable.banner1);

		mConvenientBanner
				.setPages(new LauncherHolderCreator(), INTEGERS)
				.setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
				.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
				.setOnPageChangeListener(this)
				.setCanLoop(false);
	}

	@Override
	public void onPageScrolled(int i, float v, int i1) {
		Log.d(TAG, "onPageScrolled: i = " + i);
	}

	@Override
	public void onPageSelected(int i) {
		Log.d(TAG, "onPageSelected: i = " + i);
		if (INTEGERS.size() - 1 == i) {
			showNext(true);
		} else {
			showNext(false);
		}
	}

	@Override
	public void onPageScrollStateChanged(int i) {
		Log.d(TAG, "onPageScrollStateChanged: i = " + i);
	}

	private void showNext(boolean showNext) {
		tvNext.setVisibility(showNext ? View.VISIBLE : View.GONE);
		if (showNext) {
			ObjectAnimator animator = ObjectAnimator.ofFloat(tvNext, "alpha", 0f, 0.8f);
			animator.setDuration(1000);
			animator.start();
		}
	}

	private void clickNext() {
		Log.d(TAG, "clickNext: ");
		LattePreference.setAppFlag(LauncherFragment.INIT, true);
		getSupportDelegate().startWithPop(new MainDelegate());
		LauncherActivity.NEED_LAUNCHER = false;
	}

	@Override
	protected LauncherContract.Presenter initPresenter() {
		return null;
	}
}
