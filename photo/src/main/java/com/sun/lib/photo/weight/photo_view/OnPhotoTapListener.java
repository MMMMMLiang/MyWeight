package com.sun.lib.photo.weight.photo_view;

import android.widget.ImageView;

/**
 * @author cool.
 * Date: 2019/5/5
 * Time: 10:51
 * Info:
 */
public interface OnPhotoTapListener {

    /**
     * 接收用户点击照片位置的回调。只有在用户点击实际照片，点击“空白”将被忽略。
     * @param view 用户点击的ImageView
     * @param x 其中用户从可绘制文件中点击，作为可牵引宽度。
     * @param y 其中用户从可绘制文件的顶部点击，作为可牵引高度
     */
    void onPhotoTap(ImageView view, float x, float y);
}
