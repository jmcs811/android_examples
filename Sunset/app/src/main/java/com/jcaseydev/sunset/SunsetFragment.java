package com.jcaseydev.sunset;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

public class SunsetFragment extends Fragment {

    private View mSceneView;
    private View mSunView;
    private View mSkyView;

    // Colors
    private int mBlueSkyColor;
    private int mSunsetColor;
    private int mNightSkyColor;

    public static SunsetFragment newInstance() {
        return new SunsetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sunset, container, false);

        mSceneView = v;
        mSunView = v.findViewById(R.id.sun);
        mSkyView = v.findViewById(R.id.sky);

        Resources resources = getResources();
        mBlueSkyColor = resources.getColor(R.color.blue_sky);
        mSunsetColor = resources.getColor(R.color.sunset_sky);
        mNightSkyColor = resources.getColor(R.color.night_sky);

        mSceneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        return v;
    }

    private void startAnimation() {
        float sunYStart = mSunView.getTop();
        float sunYEnd = mSkyView.getHeight();

        // position animation
        ObjectAnimator heightAnimator = ObjectAnimator
                .ofFloat(mSunView, "y", sunYStart, sunYEnd)
                .setDuration(3000);

        heightAnimator.setInterpolator(new AccelerateInterpolator());

        // color animation
        ObjectAnimator sunsetSkyAnimator = ObjectAnimator
                .ofInt(mSkyView, "backgroundColor", mBlueSkyColor, mSunsetColor)
                .setDuration(3000);

        sunsetSkyAnimator.setEvaluator(new ArgbEvaluator());

        // night animation
        ObjectAnimator nightSkyAnimator = ObjectAnimator
                .ofInt(mSkyView, "backgroundColor", mSunsetColor, mNightSkyColor)
                .setDuration(3000);
        nightSkyAnimator.setEvaluator(new ArgbEvaluator());

        // start multiple animations
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet
                .play(heightAnimator)
                .with(sunsetSkyAnimator)
                .before(nightSkyAnimator);
        animatorSet.start();
    }
}
