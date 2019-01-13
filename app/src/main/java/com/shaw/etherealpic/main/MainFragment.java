package com.shaw.etherealpic.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shaw.etherealpic.R;
import com.shaw.etherealpic.R2;
import com.shaw.etherealpic.base.BaseFragment;
import com.shaw.etherealpic.di.ActivityScoped;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created on 2019/1/9.
 *
 * @author XCZ
 */
@ActivityScoped
public class MainFragment extends BaseFragment<MainContract.Presenter> implements MainContract.View {
    @BindView(R2.id.recycler_main)
    RecyclerView mRecyclerView = null;

    @Inject
    public MainFragment() {
        // Requires empty public constructor
    }

    @Override
    public Object setLayout() {
        return R.layout.frag_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initRecyclerBanner();
    }

    private void initRecyclerBanner() {
        MainAdapter adapter = new MainAdapter();
        adapter.setData(getbanner());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);


    }

    private List<Integer> getbanner() {
        final List<Integer> data = new ArrayList<>();
        data.add(R.drawable.banner0);
        data.add(R.drawable.banner1);
        return data;
    }

}
