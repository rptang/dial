package com.zyzs.ewin.dialfunc.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zyzs.ewin.dialfunc.R;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * DialFunc
 * com.zyzs.ewin.dialfunc.widget
 * TimeClockView
 * <p>
 * Created by Stiven on 2018/2/1.
 * Copyright © 2018 ZYZS-TECH. All rights reserved.
 */

public class TimeClockView extends View{

    private Paint mPaint; //画笔
    private Bitmap bitmapPointer; //指针
    private Timer mTimer = new Timer();
    private int sleepTime = 1000; //时间更新间隔时间
    private float mHourDegree; //当前时钟角度
    private long hasPassMilliseconds; //当前时间离0点时刻毫秒数
    private long oneDayMilliSeconds = 24 * 60 * 60 * 1000; //一天总毫秒数
    private int centerX; //旋转中心x
    private int centerY; //旋转中心y

    public TimeClockView(Context context) {
        this(context, null);
    }

    public TimeClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    public TimeClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
    }

    /**
     * 初始化画笔、要画的图片
     */
    private void initData(Context context) {
        mPaint = new Paint();
        bitmapPointer = BitmapFactory.decodeResource(context.getResources(), R.drawable.shijian_zz_img);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.rotate(mHourDegree, centerX, centerY);
        canvas.drawBitmap(bitmapPointer,getWidth() - bitmapPointer.getWidth(),centerY - bitmapPointer.getHeight() / 2,mPaint);
        canvas.restore();
    }

    /**
     * 时钟走起
     */
    public void start() {
        mTimer.schedule(task,0,sleepTime);
        Date date = new Date();
        hasPassMilliseconds = date.getTime() % oneDayMilliSeconds + 8 * 60 * 60 * 1000;
        System.out.println("hasPassMilliseconds="+hasPassMilliseconds);
        setTime(hasPassMilliseconds,date);
    }

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Date date = new Date();
            hasPassMilliseconds = date.getTime() % oneDayMilliSeconds + 8 * 60 * 60 * 1000;
            setTime(hasPassMilliseconds,date);
        }
    };

    /**
     * 应用打开初始化时间
     */
    public void setTime(long hasPassMilliseconds,Date date) {
        //mHourDegree = (float) Math.floor(90 + hasPassMilliseconds / 1000 / 120);
        mHourDegree = -90 + hasPassMilliseconds / 1000 / 120;
        if(mListener != null){
            mListener.update(date);
        }
        postInvalidate();
    }

    public UpdateDateListener mListener;

    public void setUpdateDateListener(UpdateDateListener listener){
        this.mListener = listener;
    }

    public interface UpdateDateListener{

        void update(Date date);
    }
}
