package com.shaw.etherealpic.ui.main;

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
public class MainDelegate extends ShawDelegate {
	@Override
	public Object setLayout() {
		return R.layout.frag_main;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

	}
}