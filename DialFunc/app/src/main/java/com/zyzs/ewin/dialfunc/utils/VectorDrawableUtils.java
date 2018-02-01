package com.zyzs.ewin.dialfunc.utils;

import android.content.Context;
import android.support.graphics.drawable.VectorDrawableCompat;
import com.zyzs.ewin.dialfunc.R;
import java.util.ArrayList;
import java.util.List;

/**
 * DialFunc
 * com.zyzs.ewin.dialfunc.utils
 * VectorDrawableUtils
 * <p>
 * Created by Stiven on 2018/2/1.
 * Copyright © 2018 ZYZS-TECH. All rights reserved.
 */

public class VectorDrawableUtils {

    /**
     * 用于判断单个字符显示
     */
    public static final String CHARACTER_0 = "0";
    public static final String CHARACTER_1 = "1";
    public static final String CHARACTER_2 = "2";
    public static final String CHARACTER_3 = "3";
    public static final String CHARACTER_4 = "4";
    public static final String CHARACTER_5 = "5";
    public static final String CHARACTER_6 = "6";
    public static final String CHARACTER_7 = "7";
    public static final String CHARACTER_8 = "8";
    public static final String CHARACTER_9 = "9";
    public static final String CHARACTER_FH = "-";
    public static final String CHARACTER_MH = ":";

    /**
     * 设置每个字符的宽高，由于不同数字宽高不一
     */
    public static final float CHARACTER_0_WIDTH = (float) 49.999;
    public static final float CHARACTER_0_HEIGHT = 88;

    public static final float CHARACTER_1_WIDTH = (float) 49.999;
    public static final float CHARACTER_1_HEIGHT = 88;

    public static final float CHARACTER_2_WIDTH = (float) 49.999;
    public static final float CHARACTER_2_HEIGHT = 88;

    public static final float CHARACTER_3_WIDTH = (float) 49.999;
    public static final float CHARACTER_3_HEIGHT = 88;

    public static final float CHARACTER_4_WIDTH = (float) 49.999;
    public static final float CHARACTER_4_HEIGHT = 88;

    public static final float CHARACTER_5_WIDTH = (float) 49.999;
    public static final float CHARACTER_5_HEIGHT = 88;

    public static final float CHARACTER_6_WIDTH = (float) 49.999;
    public static final float CHARACTER_6_HEIGHT = 88;

    public static final float CHARACTER_7_WIDTH = (float) 49.999;
    public static final float CHARACTER_7_HEIGHT = 88;

    public static final float CHARACTER_8_WIDTH = (float) 49.999;
    public static final float CHARACTER_8_HEIGHT = 88;

    public static final float CHARACTER_9_WIDTH = (float) 49.999;
    public static final float CHARACTER_9_HEIGHT = 88;

    public static final float CHARACTER_FH_WIDTH = (float) 49.999;
    public static final float CHARACTER_FH_HEIGHT = 88;

    public static final float CHARACTER_MH_WIDTH = (float) 49.999;
    public static final float CHARACTER_MH_HEIGHT = 88;

    /**
     * 用于判断当前字符显示颜色的分界值
     */
    public static final int CRITICAL_BLUE = 0;
    public static final int CRITICAL_GREEN = 20;
    public static final int CRITICAL_ORANGE = 30;
    public static final int CRITICAL_RED = 40;

    /**
     * 获取温度VectorDrawable集合
     * @return
     */
    public static List<VectorDrawableCompat> getTemperatureVDListByTemp(Context context,int temp) {

        int tintColor = getColorResourceByData(context,temp);
        String[] characters = getCharactersByData(temp);
        List<VectorDrawableCompat> temperatureVDList = new ArrayList<>();
        VectorDrawableCompat vectorDrawableCompat = null;

        for (int i = 0; i < characters.length; i++) {
            vectorDrawableCompat = getVectorDrawableByString(context,characters[i]);
            vectorDrawableCompat.setTint(tintColor);
            temperatureVDList.add(vectorDrawableCompat);
        }
        return temperatureVDList;
    }

    /**
     * 根据传入的字符串，返回VectorDrawable对象
     * @param context
     * @param character
     * @return
     */
    public static VectorDrawableCompat getVectorDrawableByString(Context context,String character) {

        float width,height;
        VectorDrawableCompat vectorDrawableCompat = null;
        switch (character) {
            case CHARACTER_0:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_0_img,context.getTheme());
                break;
            case CHARACTER_1:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_1_img,context.getTheme());
                break;
            case CHARACTER_2:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_2_img,context.getTheme());
                break;
            case CHARACTER_3:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_3_img,context.getTheme());
                break;
            case CHARACTER_4:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_4_img,context.getTheme());
                break;
            case CHARACTER_5:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_5_img,context.getTheme());
                break;
            case CHARACTER_6:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_6_img,context.getTheme());
                break;
            case CHARACTER_7:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_7_img,context.getTheme());
                break;
            case CHARACTER_8:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_8_img,context.getTheme());
                break;
            case CHARACTER_9:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_9_img,context.getTheme());
                break;
            case CHARACTER_FH:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_fh_img,context.getTheme());
                break;
            case CHARACTER_MH:
                vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_mh_img,context.getTheme());
                break;
        }
        return vectorDrawableCompat;
    }

    /**
     * 根据当前的数据值，返回显示颜色资源
     */
    public static int getColorResourceByData(Context context,int temp){

        int tintColor = -1;

        if (temp <= CRITICAL_BLUE){
            tintColor = context.getResources().getColor(R.color.c_50F5FF);
        }else if (temp >CRITICAL_BLUE && temp <= CRITICAL_GREEN){
            tintColor = context.getResources().getColor(R.color.c_64FF96);
        }else if (temp >CRITICAL_GREEN && temp <= CRITICAL_ORANGE){
            tintColor = context.getResources().getColor(R.color.c_FFC864);
        }else {
            tintColor = context.getResources().getColor(R.color.c_FF5050);
        }
        return tintColor;
    }

    /**
     * 根据当前的int类型数据值，转换为字符数组
     */
    public static String[] getCharactersByData(int data){

        char[] chars = String.valueOf(data).toCharArray();
        String[] characters = new String[chars.length];

        for (int i = 0; i < chars.length; i++) {
            characters[i] = Character.toString(chars[i]);
        }
        return characters;
    }
}
