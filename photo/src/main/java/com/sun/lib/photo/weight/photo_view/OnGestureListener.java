package com.sun.lib.photo.weight.photo_view;

/**
 * @author cool.
 * Date: 2019/5/5
 * Time: 10:45
 * Info:
 */
public interface OnGestureListener {
    void onDrag(float dx, float dy);

    void onFling(float startX, float startY, float velocityX,
                 float velocityY);

    void onScale(float scaleFactor, float focusX, float focusY);
}
