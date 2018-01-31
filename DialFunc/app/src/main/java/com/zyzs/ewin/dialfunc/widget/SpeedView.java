package com.zyzs.ewin.dialfunc.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zyzs.ewin.dialfunc.R;

/**
 * DialFunc
 * com.zyzs.ewin.dialfunc.widget
 * SpeedView
 * <p>
 * Created by Stiven on 2018/1/31.
 * Copyright © 2018 ZYZS-TECH. All rights reserved.
 */

public class SpeedView extends View{

    private Paint mPaint; //画笔
    private Bitmap bitmapPointer; //指针
    private float currDegree = 0; //当前绕中心点旋转度数，初始化0度，图片垂直居中，靠左
    private int centerX; //旋转中心x
    private int centerY; //旋转中心y
    private int bitmapMarginLeft = 29; //旋转的图片离整体view边缘距离

    public SpeedView(Context context) {
        this(context, null);
    }

    public SpeedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    public SpeedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        centerX = getWidth() / 2;
        centerY = getWidth() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawPointer(canvas);
    }

    private void drawPointer(Canvas canvas){
        canvas.save();
        canvas.rotate(0, centerX, centerY);
        canvas.drawBitmap(bitmapPointer,getWidth() / 2 - 170,getWidth() / 2 - bitmapPointer.getHeight() / 2,mPaint);
        canvas.restore();
    }

    /**
     * 初始化画笔、要画的图片
     */
    private void initData(Context context) {
        mPaint = new Paint();
        bitmapPointer = BitmapFactory.decodeResource(context.getResources(),R.drawable.mabiao_zz_img);
    }

    /**
     * 根据当前传入的速度，计算旋转的角度
     * @param currSpeed
     */
    public void setCurrSpeed(int currSpeed){
        currDegree = (float) (90/27.45 * 36);
        postInvalidate();
    }
}
