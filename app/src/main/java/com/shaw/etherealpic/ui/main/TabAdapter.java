package com.shaw.etherealpic.ui.main;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created on 2019/2/2.
 *
 * @author XCZ
 */
public class TabAdapter extends FragmentStatePagerAdapter {
	private final List<Fragment> mFragmentList = new ArrayList<>();
	private final List<String> mFragmentTitleList = new ArrayList<>();

	TabAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		return mFragmentList.get(position);
	}

	public void addFragment(Fragment fragment, String title) {
		mFragmentList.add(fragment);
		mFragmentTitleList.add(title);
	}

	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		return mFragmentTitleList.get(position);
	}

	@Override
	public int getCount() {
		return mFragmentList.size();
	}
}
