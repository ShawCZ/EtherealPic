package com.shaw.etherealpic.ui.popular;

import android.os.Bundle;
import android.view.View;

import com.shaw.core.delegates.ShawDelegate;
import com.shaw.etherealpic.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created on 2019/2/2.
 *
 * @author XCZ
 */
public class PopularDelegate extends ShawDelegate {
	@Override
	public Object setLayout() {
		return R.layout.delegate_popular;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

	}
}
