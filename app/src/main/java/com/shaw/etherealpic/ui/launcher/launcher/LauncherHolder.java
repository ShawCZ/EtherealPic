package com.shaw.etherealpic.ui.launcher.launcher;

import android.content.Context;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * Created by shaw on 2017/9/2.
 */

public class LauncherHolder implements Holder<Integer> {

    private AppCompatImageView mImageView = null;

    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);
        return mImageView;
    }

    //每次滑动，更新图片
    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        mImageView.setBackgroundResource(data);
    }

}
