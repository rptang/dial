package com.zyzs.ewin.dialfunc.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * DialFunc
 * com.zyzs.ewin.dialfunc.widget
 * TrigonView
 * <p>
 * Created by Stiven on 2018/3/30.
 * Copyright © 2018 ZYZS-TECH. All rights reserved.
 */

public class TrigonView extends View {

    //无参
    public TrigonView(Context context) {
        super(context);
    }

    //有参
    public TrigonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.WHITE);
        //实例化路径
        Path path = new Path();
        path.moveTo(80, 200);// 此点为多边形的起点
        path.lineTo(200, 150);
        path.lineTo(80, 220);
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, p);
    }
}
