package com.whb.simplerotate3d;


import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.whb.simplerotate3d.lib.AnimationHelper;


public class ThreeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private TextView textView;

    private String mParam1;

    public ThreeFragment() {
    }

    public static ThreeFragment newInstance(String param1) {
        ThreeFragment fragment = new ThreeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.text);
        textView.setText(mParam1);

    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        Animator animator = AnimationHelper.onCreateAnimator(transit, enter, nextAnim);
        if (animator == null) {
            return super.onCreateAnimator(transit, enter, nextAnim);
        } else {
            return animator;
        }
    }
}
