/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.sun.view.weight.easing;


import com.sun.view.weight.easing.back.BackEaseIn;
import com.sun.view.weight.easing.back.BackEaseInOut;
import com.sun.view.weight.easing.back.BackEaseOut;
import com.sun.view.weight.easing.bounce.BounceEaseIn;
import com.sun.view.weight.easing.bounce.BounceEaseInOut;
import com.sun.view.weight.easing.bounce.BounceEaseOut;
import com.sun.view.weight.easing.circ.CircEaseIn;
import com.sun.view.weight.easing.circ.CircEaseInOut;
import com.sun.view.weight.easing.circ.CircEaseOut;
import com.sun.view.weight.easing.cubic.CubicEaseIn;
import com.sun.view.weight.easing.cubic.CubicEaseInOut;
import com.sun.view.weight.easing.cubic.CubicEaseOut;
import com.sun.view.weight.easing.elastic.ElasticEaseIn;
import com.sun.view.weight.easing.elastic.ElasticEaseOut;
import com.sun.view.weight.easing.expo.ExpoEaseIn;
import com.sun.view.weight.easing.expo.ExpoEaseInOut;
import com.sun.view.weight.easing.expo.ExpoEaseOut;
import com.sun.view.weight.easing.linear.Linear;
import com.sun.view.weight.easing.quad.QuadEaseIn;
import com.sun.view.weight.easing.quad.QuadEaseInOut;
import com.sun.view.weight.easing.quad.QuadEaseOut;
import com.sun.view.weight.easing.quint.QuintEaseIn;
import com.sun.view.weight.easing.quint.QuintEaseInOut;
import com.sun.view.weight.easing.quint.QuintEaseOut;
import com.sun.view.weight.easing.sine.SineEaseIn;
import com.sun.view.weight.easing.sine.SineEaseInOut;
import com.sun.view.weight.easing.sine.SineEaseOut;

public enum  Skill {

    BackEaseIn(BackEaseIn.class),
    BackEaseOut(BackEaseOut.class),
    BackEaseInOut(BackEaseInOut.class),

    BounceEaseIn(BounceEaseIn.class),
    BounceEaseOut(BounceEaseOut.class),
    BounceEaseInOut(BounceEaseInOut.class),

    CircEaseIn(CircEaseIn.class),
    CircEaseOut(CircEaseOut.class),
    CircEaseInOut(CircEaseInOut.class),

    CubicEaseIn(CubicEaseIn.class),
    CubicEaseOut(CubicEaseOut.class),
    CubicEaseInOut(CubicEaseInOut.class),

    ElasticEaseIn(ElasticEaseIn.class),
    ElasticEaseOut(ElasticEaseOut.class),

    ExpoEaseIn(ExpoEaseIn.class),
    ExpoEaseOut(ExpoEaseOut.class),
    ExpoEaseInOut(ExpoEaseInOut.class),

    QuadEaseIn(QuadEaseIn.class),
    QuadEaseOut(QuadEaseOut.class),
    QuadEaseInOut(QuadEaseInOut.class),

    QuintEaseIn(QuintEaseIn.class),
    QuintEaseOut(QuintEaseOut.class),
    QuintEaseInOut(QuintEaseInOut.class),

    SineEaseIn(SineEaseIn.class),
    SineEaseOut(SineEaseOut.class),
    SineEaseInOut(SineEaseInOut.class),

    Linear(Linear.class);


    private Class easingMethod;

    private Skill(Class clazz) {
        easingMethod = clazz;
    }

    public BaseEasingMethod getMethod(float duration) {
        try {
            return (BaseEasingMethod)easingMethod.getConstructor(float.class).newInstance(duration);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Can not init easingMethod instance");
        }
    }
}
