package com.sun.lib.photo.select.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 图片预览 RecyclerView
 * Create By lishilin On 2019/3/25
 */
public class PreviewRecyclerView extends RecyclerView {

    private boolean isLock;// 是否锁住 RecyclerView ，避免和 PhotoView 双指放大缩小操作冲突

    public PreviewRecyclerView(@NonNull Context context) {
        super(context);
    }

    public PreviewRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PreviewRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            // 非第一个触点按下
            case MotionEvent.ACTION_POINTER_DOWN:
                isLock = true;
                break;
            // 最后一个触点抬起
            case MotionEvent.ACTION_UP:
                isLock = false;
                break;
            default:
                break;
        }
        if (isLock) {
            // 不拦截，交给子View处理
            return false;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            // 非第一个触点按下
            case MotionEvent.ACTION_POINTER_DOWN:
                isLock = true;
                break;
            // 最后一个触点抬起
            case MotionEvent.ACTION_UP:
                isLock = false;
                break;
                default:
                    break;
        }
        return super.dispatchTouchEvent(event);
    }

}
