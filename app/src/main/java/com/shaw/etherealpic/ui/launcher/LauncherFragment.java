package com.shaw.etherealpic.ui.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.shaw.etherealpic.R;
import com.shaw.etherealpic.R2;
import com.shaw.etherealpic.base.BaseFragment;
import com.shaw.etherealpic.di.ActivityScoped;
import com.shaw.etherealpic.main.MainActivity;
import com.shaw.etherealpic.util.ActivityUtils;
import com.shaw.etherealpic.util.LattePreference;
import com.shaw.etherealpic.util.glide.GlideApp;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.Lazy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@ActivityScoped
public class LauncherFragment extends BaseFragment<LauncherContract.Presenter> implements LauncherContract.View {
    @BindView(R2.id.img)
    AppCompatImageView imgLauncher = null;

    //设置图片加载策略
    public static final RequestOptions OPTIONS =
            new RequestOptions()
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.ALL);

    public static final String INIT = "init";

    @Inject
    Lazy<LauncherScrollFragment> scrollFragmentLazy;

    @Inject
    public LauncherFragment() {
        // Requires empty public constructor
    }

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
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            getActivity().finish();
            LauncherActivity.NEED_LAUNCHER = false;
        } else {
            ActivityUtils.replaceFragmentToActivity(getActivity().getSupportFragmentManager(), scrollFragmentLazy.get(), R.id.delegate_container);
        }
    }
}
