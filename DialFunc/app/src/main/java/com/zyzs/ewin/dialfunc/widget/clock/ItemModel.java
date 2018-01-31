package com.zyzs.ewin.dialfunc.widget.clock;

import android.graphics.Color;

/**
 * Created by zhukaiqiang on 2017/7/13.
 */

public class ItemModel {
    private int startX = 0;
    private int startY = 0;
    private int width = 0;
    private int height = 0;
    private int radius = 0;
    private int color = Color.BLACK;
    private int rotateX = 0;
    private int rotateY = 0;
    private String style = "HOUR";// HOUR MINUTE SECOND CIRCLE

    public ItemModel(int startX, int startY, int width, int height, int radius, int color, int rotateX, int rotateY, String style) {
        this.startX = startX; //起始位置的坐标
        this.startY = startY;
        this.width = width; //view的宽高
        this.height = height;
        this.radius = radius; // 圆角
        this.color = color;
        this.rotateX = rotateX; //旋转中心坐标
        this.rotateY = rotateY;
        this.style = style; // 所画的类别
    }

    public ItemModel(int startX, int startY, int radius, int color, String style) {
        this.startX = startX; //圆心坐标
        this.startY = startY;
        this.radius = radius; // 半径
        this.color = color;
        this.style = style;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRadius() {
        return radius;
    }

    public int getColor() {
        return color;
    }

    public int getRotateX() {
        return rotateX;
    }

    public int getRotateY() {
        return rotateY;
    }

    public String getStyle() {
        return style;
    }
}
