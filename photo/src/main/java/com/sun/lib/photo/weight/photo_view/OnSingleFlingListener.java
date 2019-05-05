package com.sun.lib.photo.weight.photo_view;

import android.view.MotionEvent;

/**
 * @author cool.
 * Date: 2019/5/5
 * Time: 10:55
 * Info:
 */
public interface OnSingleFlingListener {

    /**
     * 一种回调，用于接收用户在ImageView上的抛出位置。如果用户在视图上的任何位置都会抛出。
     * @param e1 motionevent用户第一次触摸。
     * @param e2 MotionEvent用户最后一次触摸。
     * @param velocityX 用户水平投掷的距离。
     * @param velocityY 用户垂直投掷的速度距离。
     * @return
     */
    boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY);
}
