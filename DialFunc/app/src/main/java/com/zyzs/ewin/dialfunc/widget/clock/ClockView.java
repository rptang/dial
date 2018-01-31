package com.zyzs.ewin.dialfunc.widget.clock;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ClockView extends View {

    private Context mContext;
    private Paint mPaint;
    private float mSecondDegree;
    private float mMinDegree;
    private float mHourDegree;
    private boolean mIsNight;
    private float mTotalSecond;
    private int sleepTime = 1000;
    private Timer mTimer = new Timer();

    private List<ItemModel> itemList = new ArrayList();


    private Bitmap backImage = BitmapFactory.decodeResource(this.getResources(), 0);

    public ClockView(Context context) {
        this(context, null);
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initPainter();
    }

    /**
     * 初始化画笔
     */
    private void initPainter() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setFilterBitmap(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }
    /**
     * 测量控件尺寸
     *
     * @param measureSpec
     * @return
     */
    private int measureWidth(int measureSpec) {
        int result;
        if (backImage == null) {
            result = measureSpec;
        } else {
            result = backImage.getWidth();
        }
        return result;
    }
    /**
     * 测量控件尺寸
     *
     * @param measureSpec
     * @return
     */
    private int measureHeight(int measureSpec) {
        int result;
        if (backImage == null) {
            result = measureSpec;
        } else {
            result = backImage.getHeight();
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //背景
        canvas.drawBitmap(backImage, 0, 0, mPaint);

        for (int i = 0; i < itemList.size(); i++) {
            ItemModel model = itemList.get(i);
            if (model.getStyle().equals("CIRCLE")) {
                //圆心
                mPaint.setColor(model.getColor());
                canvas.drawCircle(model.getStartX(), model.getStartY(), model.getRadius(), mPaint);
            } else {
                drawPoint(model, canvas);
            }
        }

        }

    private void drawPoint(ItemModel model, Canvas canvas) {
        canvas.save();
        canvas.rotate(getDegree(model), getWidth() / 2, getHeight() / 2);
        mPaint.setColor(model.getColor());
        mPaint.setStyle(Paint.Style.FILL);
        RectF oval2 = new RectF(model.getStartX(), model.getStartY() - model.getHeight() / 2, model.getStartX() + model.getWidth(), model.getStartY() + model.getHeight() / 2);// 设置个新的长方形
        canvas.drawRoundRect(oval2, model.getRadius(), model.getRadius(), mPaint);
        canvas.restore();
    }

    private float getDegree(ItemModel model) {
        float degree = 0;
        switch (model.getStyle()) {
            case "HOUR":
                degree = mHourDegree;
                break;
            case "MINUTE":
                degree = mMinDegree;
                break;
            case "SECOND":
                degree = mSecondDegree;
                break;
        }
        return degree;
    }

    public void setItemList(List<ItemModel> itemList) {
        this.itemList = itemList;
        postInvalidate();
    }

    /**
         * 手动设置时间
         *
         * @param hour
         * @param min
         */

    public void setTime(int hour, int min) {
        setTotalSecond(hour * 3600f + min * 60f);
    }

    /**
     * 应用打开初始化时间
     *
     * @param hour
     * @param min
     * @param second
     */
    public void setTime(int hour, int min, int second) {
        hour += 9;
        second += 45;
        if (hour >= 12) {
            hour %= 12;
            mIsNight = true;
        } else {
            mIsNight = false;
        }
        if (second >= 60) {
            second %= 60;
        }
        mHourDegree = hour * 30f + min / 2f + second / 120f;
        min += 45;
        if (min >= 60) {
            min %= 60;
        }
        mMinDegree = min * 6f;
        mSecondDegree = second * 6f;
        postInvalidate();
    }

    /**
     * 获取时间对应的总秒数
     *
     * @return
     */
    public float getTimeTotalSecond() {
        if (mIsNight) {
            mTotalSecond = mHourDegree * 120 + 12 * 3600;
            return mTotalSecond;
        } else {
            mTotalSecond = mHourDegree * 120;
            return mTotalSecond;
        }
    }

    /**
     * 设置总时间（最大值为 24 * 3600）
     *
     * @param mTotalSecond
     */
    public void setTotalSecond(float mTotalSecond) {
        if (mTotalSecond >= (24 * 3600)) {
            this.mTotalSecond = mTotalSecond - 24 * 3600;
        } else {
            this.mTotalSecond = mTotalSecond;
        }
        int hour = (int) (mTotalSecond / 3600);
        int min = (int) ((mTotalSecond - hour * 3600) * 1.0 / 60);
        int second = (int) (mTotalSecond - hour * 3600 - min * 60);
        setTime(hour, min, second);
    }

    /**
     * 获取hour
     *
     * @return
     */
    public int getHour() {
        return (int) (getTimeTotalSecond() / 3600);
    }

    /**
     * 获取Min
     *
     * @return
     */
    public int getMin() {
        return (int) ((getTimeTotalSecond() - getHour() * 3600) / 60);
    }

    public int getSecond() {
        return (int) (getTimeTotalSecond() - getHour() * 3600 - getMin() * 60);
    }

    /**
     * 时钟走起
     */
    public void start() {
        mTimer.schedule(task,0,sleepTime);
        Date date = new Date();
        setTime(date.getHours(), date.getMinutes(), date.getSeconds());
    }

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Date date = new Date();
            setTime(date.getHours(), date.getMinutes(), date.getSeconds());
        }
    };

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
        postInvalidate();
    }

    public void setBackImage(Bitmap bmp1) {
        this.backImage = bmp1;
        postInvalidate();
    }

    /**
     * 尺寸转换工具类
     */
    private static class SizeUtils {
        public static int dp2px(Context context, float dp) {
            final float density = context.getResources().getDisplayMetrics().density;
            return (int) (dp * density + 0.5);
        }

        public static int px2dp(Context context, float px) {
            final float density = context.getResources().getDisplayMetrics().density;
            return (int) (px / density + 0.5);
        }
    }
}
