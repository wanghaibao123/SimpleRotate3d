package com.whb.simplerotate3d;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;

import com.whb.simplerotate3d.lib.AnimationHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container_1, OneFragment.newInstance("第一个"),"tag_1_1").commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_2,TwoFragment.newInstance("第一个"),"tag_2_1").commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_3,ThreeFragment.newInstance("第一个"),"tag_3_1").commit();

    }


    boolean tagBoolean = false;
    @SuppressLint("ResourceType")
    public void onChangeOne(View view) {
        Fragment fragment =null;
        String tag = null;
        if(tagBoolean) {
            tag = "tag_1_1";
            fragment = getFragmentManager().findFragmentByTag(tag);
            if(fragment == null) {
                fragment = OneFragment.newInstance("第一个");
            }

        } else {
            tag = "tag_1_2";
            fragment = getFragmentManager().findFragmentByTag(tag);
            if(fragment == null) {
                fragment = OneFragment.newInstance("第二个");
            }
        }
        getFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.fragment_second_3d_reversal_enter, R.anim.fragment_second_3d_reversal_exit)
                .replace(R.id.fragment_container_1, fragment, tag).commit();
        tagBoolean = !tagBoolean;
    }


    boolean tagBoolean2 = false;
    public void onChangeTwo(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.Fragment fragment =null;
        String tag = null;
        if(tagBoolean2) {
            tag = "tag_2_1";
            fragment = fragmentManager.findFragmentByTag(tag);
            if(fragment == null) {
                fragment = TwoFragment.newInstance("第一个");
            }

        } else {
            tag = "tag_2_2";
            fragment = fragmentManager.findFragmentByTag(tag);
            if(fragment == null) {
                fragment = TwoFragment.newInstance("第二个");
            }
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        AnimationHelper.setUpRotate3dAnimation(transaction);
        transaction.replace(R.id.fragment_container_2, fragment, tag).commit();
        tagBoolean2 = !tagBoolean2;
    }

    boolean tagBoolean3 = false;
    public void onChangeThree(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.Fragment fragment =null;
        String tag = null;
        if(tagBoolean3) {
            tag = "tag_3_1";
            fragment = fragmentManager.findFragmentByTag(tag);
            if(fragment == null) {
                fragment = ThreeFragment.newInstance("第一个");
            }

        } else {
            tag = "tag_3_2";
            fragment = fragmentManager.findFragmentByTag(tag);
            if(fragment == null) {
                fragment = ThreeFragment.newInstance("第二个");
            }
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        AnimationHelper.setUpRotate3dAnimation(transaction);
        transaction.replace(R.id.fragment_container_3, fragment, tag).commit();
        tagBoolean3 = !tagBoolean3;

    }

    boolean tagBoolean4 = false;
    public void onChangeFour(View view) {
        final View view0 = findViewById(R.id.left_bottom_0);
        final View view1 = findViewById(R.id.left_bottom_1);
        final Animation rotate3dEnterAnimation = AnimationHelper.createRotate3dEnterAnimation();
        final Animation rotate3dExitAnimation = AnimationHelper.createRotate3dExitAnimation();
        if (tagBoolean4) {
            view0.setVisibility(View.VISIBLE);
            view1.setVisibility(View.INVISIBLE);
            view0.startAnimation(rotate3dEnterAnimation);
            view1.startAnimation(rotate3dExitAnimation);
        } else {
            view0.setVisibility(View.INVISIBLE);
            view1.setVisibility(View.VISIBLE);
            view0.startAnimation(rotate3dExitAnimation);
            view1.startAnimation(rotate3dEnterAnimation);
        }
        tagBoolean4 = !tagBoolean4;
    }

    boolean tagBoolean5 = false;
    public void onCHangeFif(View view) {
        View view0 = findViewById(R.id.right_bottom_0);
        View view1 = findViewById(R.id.right_bottom_1);
        Animator rotate3dEnterAnimator = AnimationHelper.createRotate3dEnterAnimator();
        Animator rotate3dExitAnimator = AnimationHelper.createRotate3dExitAnimator();
        if (tagBoolean5) {
            rotate3dEnterAnimator.setTarget(view1);
            rotate3dEnterAnimator.start();
            rotate3dExitAnimator.setTarget(view0);
            rotate3dExitAnimator.start();
        } else {
            rotate3dEnterAnimator.setTarget(view0);
            rotate3dEnterAnimator.start();
            rotate3dExitAnimator.setTarget(view1);
            rotate3dExitAnimator.start();
        }
        tagBoolean5 = !tagBoolean5;
    }
}
