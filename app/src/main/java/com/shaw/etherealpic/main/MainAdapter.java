package com.shaw.etherealpic.main;

import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shaw.etherealpic.R;
import com.shaw.etherealpic.util.DimenUtil;
import com.shaw.etherealpic.util.glide.CustomAppGlideModule;
import com.shaw.etherealpic.util.glide.GlideApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Shaw on 2019/1/13 16:38
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private final List<Integer> data = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main_banner, viewGroup, false);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = DimenUtil.getScreenWidth() - 300;
        view.setLayoutParams(params);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        if (!data.isEmpty()) {
            GlideApp.with(viewHolder.mImgCollection.getContext())
                    .applyDefaultRequestOptions(CustomAppGlideModule.RECYCLER_OPTIONS)
                    .load(data.get(position % data.size()))
                    .into(viewHolder.mImgCollection);
//            ObjectAnimator animator = ObjectAnimator.ofFloat(viewHolder.mCardView,"scaleX",1f,1.2f);
//            animator.setDuration(1000);
//            animator.start();

            viewHolder.mCardView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus){
                        scaleUp(v);
                    }else {
                        scaleDown(v);
                    }
                }
            });

        }
    }

    //1.08表示放大倍数,可以随便改
    private void scaleUp(View view) {
        ViewCompat.animate(view)
                .setDuration(200)
                .scaleX(1.08f)
                .scaleY(1.08f)
                .start();
    }

    private void scaleDown(View view) {
        ViewCompat.animate(view)
                .setDuration(200)
                .scaleX(1f)
                .scaleY(1f)
                .start();
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public void setData(List<Integer> data) {
        this.data.addAll(data);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public final CardView mCardView;
        public final AppCompatImageView mImgCollection;
        public final AppCompatTextView mTvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mCardView = itemView.findViewById(R.id.item_card);
            this.mImgCollection = itemView.findViewById(R.id.img_collection);
            this.mTvDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
