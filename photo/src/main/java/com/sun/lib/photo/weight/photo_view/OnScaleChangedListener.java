package com.sun.lib.photo.weight.photo_view;

/**
 * @author cool.
 * Date: 2019/5/5
 * Time: 10:53
 * Info:
 */
public interface OnScaleChangedListener {

    /**
     * 刻度改变时回调
     * @param scaleFactor scaleFactor比例因子（缩小小于1，放大大于1）
     * @param focusX X位置
     * @param focusY Y位置
     */
    void onScaleChange(float scaleFactor, float focusX, float focusY);
}
