package com.shaw.etherealpic.util.glide.recycler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.shaw.etherealpic.model.bean.PublicBean;
import com.shaw.etherealpic.util.glide.GlideApp;

import java.util.Collections;
import java.util.List;

/**
 * Created on 2018/12/26.
 *
 * @author XCZ
 */
public class MyPreloadModelProvider implements ListPreloader.PreloadModelProvider<String> {
	private final AppCompatActivity mActivity;
	private final List<PublicBean> mUrls;

	public MyPreloadModelProvider(AppCompatActivity activity, List<PublicBean> urls) {
		mActivity = activity;
		mUrls = urls;
	}

	@NonNull
	@Override
	public List<String> getPreloadItems(int position) {
		String url = mUrls.get(position).getUrl();
		if (TextUtils.isEmpty(url)) {
			return Collections.emptyList();
		}
		return Collections.singletonList(url);
	}

	@Nullable
	@Override
	public RequestBuilder getPreloadRequestBuilder(@NonNull String url) {
		return GlideApp.with(mActivity)
				.load(url);
	}
}
