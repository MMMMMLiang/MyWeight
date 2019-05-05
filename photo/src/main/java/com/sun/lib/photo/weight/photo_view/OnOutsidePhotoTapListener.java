package com.sun.lib.photo.weight.photo_view;

import android.widget.ImageView;

/**
 * @author cool.
 * Date: 2019/5/5
 * Time: 10:50
 * Info:
 */
public interface OnOutsidePhotoTapListener {

    /**
     * 照片外部已经处理
     * @param imageView 照片
     */
    void onOutsidePhotoTap(ImageView imageView);
}
