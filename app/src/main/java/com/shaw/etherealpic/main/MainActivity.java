package com.shaw.etherealpic.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.shaw.etherealpic.R;
import com.shaw.etherealpic.base.BaseActivity;
import com.shaw.etherealpic.util.ActivityUtils;

public class MainActivity extends BaseActivity<MainContract.Presenter, MainFragment> {
    private static final String TAG = "MainActivity";

    protected void onBindView(@Nullable Bundle savedInstanceState) {
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (mainFragment == null) {
            // Get the fragment from dagger
            mainFragment = mFragmentProvider.get();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment, R.id.contentFrame);
        }
    }
}
