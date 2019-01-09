package com.shaw.etherealpic.ui.launcher.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by shaw on 2017/9/2.
 */

public class LauncherHolderCreator implements CBViewHolderCreator<LauncherHolder> {
    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
