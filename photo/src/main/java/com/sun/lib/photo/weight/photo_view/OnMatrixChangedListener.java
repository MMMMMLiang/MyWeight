package com.sun.lib.photo.weight.photo_view;

import android.graphics.RectF;

/**
 * @author cool.
 * Date: 2019/5/5
 * Time: 10:49
 * Info:
 */
public interface OnMatrixChangedListener {
    /**
     * 当显示可绘图项的矩阵已更改时的回调。
     * 这可能是因为视图的边界已更改，或者用户已缩放。
     * @param rect 显示可绘制的新边界的矩形
     */
    void onMatrixChanged(RectF rect);
}
