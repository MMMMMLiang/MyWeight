package com.sun.view.weight.animations.specials.out;

import android.animation.ObjectAnimator;
import android.view.View;

import com.sun.view.weight.animations.BaseViewAnimator;
import com.sun.view.weight.easing.Glider;
import com.sun.view.weight.easing.Skill;


public class TakingOffAnimator extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "scaleX", 1f, 1.5f)),
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "scaleY", 1f, 1.5f)),
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "alpha", 1, 0))
        );
    }
}
