package com.zyzs.ewin.dialfunc.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * DialFunc
 * com.zyzs.ewin.dialfunc.widget
 * LiquidNumberText
 * <p>
 * Created by Stiven on 2018/1/4.
 * Copyright © 2018 ZYZS-TECH. All rights reserved.
 */

public class LiquidNumberText extends TextView {

    static String fongUrl = "fonts/液晶数字字体.TTF";
    static String fongUrl1 = "fonts/液晶数字.ttf";
    static String fongUrl2 = "fonts/LCDM2N__.TTF";
    static String fongUrl3 = "fonts/LEDBDREV.TTF";
    static String fongUrl4 = "fonts/LiquidCrystal-Light.otf";
    static String fongUrl5 = "fonts/LiquidCrystal-Normal.otf"; //****
    static String fongUrl6 = "fonts/Let's go Digital Regular.ttf";
    static String fongUrl7 = "fonts/DISPLAY FREE TFB.ttf";
    static String fongUrl8 = "fonts/UnidreamLED.ttf";
    static String fongUrl9 = "fonts/Digital-7Mono.TTF";
    static String fongUrl10 = "fonts/Quartz Regular.ttf"; //****
    static String fongUrl11 = "fonts/Pixel LCD-7.ttf"; //****
    static Typeface tf;

    public LiquidNumberText(Context context) {
        super(context);
        init(context);
    }

    public LiquidNumberText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LiquidNumberText(Context context, AttributeSet attrs, int defSyle) {
        super(context, attrs, defSyle);
        init(context);
    }

    /***
     * 设置字体
     *
     * @return
     */
    public void init(Context context) {
        setTypeface(setFont(context));
    }

    public Typeface setFont(Context context) {
        if (tf == null) {
            tf = Typeface.createFromAsset(context.getAssets(), fongUrl10);
        }
        return tf;
    }
}
