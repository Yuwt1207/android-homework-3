package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private ListView lv;
    private LottieAnimationView animationView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View v=inflater.inflate(R.layout.fragment_placeholder,container,false);
        lv=v.findViewById(R.id.list);
        animationView=v.findViewById(R.id.animation_view);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        animationView.playAnimation();
        lv.setAlpha(0f);
        lv.setVisibility(View.VISIBLE);
        lv.setAdapter(new Adapter());

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                lv.animate().alpha(1f).setDuration(1000).setListener(null);
                animationView.animate()
                        .alpha(0f)
                        .setDuration(1000)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                animationView.setVisibility(View.GONE);
                            }
                        });
            }
        }, 5000);
    }
}
