package com.shaw.etherealpic.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.shaw.core.delegates.ShawDelegate;
import com.shaw.etherealpic.R;
import com.shaw.etherealpic.R2;
import com.shaw.etherealpic.ui.popular.PopularDelegate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * Created on 2019/2/2.
 *
 * @author XCZ
 */
public class MainDelegate extends ShawDelegate {
	@BindView(R2.id.toolbar)
	Toolbar mToolbar = null;

	@Override
	public Object setLayout() {
		return R.layout.frag_main;
	}

	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
		//if you want to update the items at a later time it is recommended to keep it in a variable
		PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.drawer_item_home);
		SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_settings);
		Drawer result = new DrawerBuilder()
				.withActivity(getProxyActivity())
				.withToolbar(mToolbar)
				.addDrawerItems(
						item1,
						new DividerDrawerItem(),
						item2,
						new SecondaryDrawerItem().withName(R.string.drawer_item_settings)
				)
				.withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
					@Override
					public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
						// do something with the clicked item :D
						return false;
					}
				})
				.build();
		//modify an item of the drawer
		item1.withName("A new name for this drawerItem").withBadge("19").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.md_red_700));
//notify the drawer about the updated element. it will take care about everything else
		result.updateItem(item1);

//to update only the name, badge, icon you can also use one of the quick methods
		result.updateName(1, new StringHolder("A new name"));

//the result object also allows you to add new items, remove items, add footer, sticky footer, ..
		result.addItem(new DividerDrawerItem());

		ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
		TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
		TabAdapter adapter = new TabAdapter(getProxyActivity().getSupportFragmentManager());
		adapter.addFragment(new PopularDelegate(), "Tab 1");
		adapter.addFragment(new PopularDelegate(), "Tab 2");
		adapter.addFragment(new PopularDelegate(), "Tab 3");
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);
	}
}
