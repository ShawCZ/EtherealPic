package com.shaw.etherealpic.ui.launcher;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.shaw.core.mvp.PresenterDelegate;
import com.shaw.core.util.glide.GlideApp;
import com.shaw.core.util.storage.LattePreference;
import com.shaw.etherealpic.R;
import com.shaw.etherealpic.R2;
import com.shaw.etherealpic.ui.main.MainDelegate;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
public class LauncherFragment extends PresenterDelegate<LauncherContract.Presenter> implements LauncherContract.View {
	@BindView(R2.id.img)
	AppCompatImageView imgLauncher = null;

	//设置图片加载策略
	public static final RequestOptions OPTIONS =
			new RequestOptions()
					.skipMemoryCache(true)
					.diskCacheStrategy(DiskCacheStrategy.ALL);

	public static final String INIT = "init";

	@Override
	public Object setLayout() {
		return R.layout.frag_launcher;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
		//请求数据
		BitmapTransitionOptions bitmapTransitionOptions = new BitmapTransitionOptions();
		bitmapTransitionOptions.transition(R.anim.glide_animate);
		imgLauncher.setScaleType(ImageView.ScaleType.FIT_XY);
		GlideApp.with(this)
				.applyDefaultRequestOptions(OPTIONS)
				.asBitmap()
				.load(R.drawable.launcher_bg)
				.transition(bitmapTransitionOptions)
				.into(imgLauncher);
	}

	@Override
	public void onResume() {
		super.onResume();
		//倒计时
		Disposable disposable = Observable.intervalRange(0, 5, 0, 1, TimeUnit.SECONDS)
				.observeOn(AndroidSchedulers.mainThread())
				.doOnComplete(this::endLauncher)
				.subscribe();
	}

	private void endLauncher() {
		//已经进入过app，直接进入主界面
		if (LattePreference.getAppFlag(INIT)) {
			getSupportDelegate().startWithPop(new MainDelegate());
			LauncherActivity.NEED_LAUNCHER = false;
		} else {
			getSupportDelegate().startWithPop(new LauncherScrollFragment());
		}
	}

	@Override
	protected LauncherContract.Presenter initPresenter() {
		return null;
	}
}
