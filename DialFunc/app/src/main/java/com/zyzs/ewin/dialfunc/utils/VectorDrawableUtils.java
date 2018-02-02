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

    public static final float CHARACTER_1_WIDTH = (float) 10.567;
    public static final float CHARACTER_1_HEIGHT = 88;

    public static final float CHARACTER_2_WIDTH = 50;
    public static final float CHARACTER_2_HEIGHT = 88;

    public static final float CHARACTER_3_WIDTH = (float) 43.896;
    public static final float CHARACTER_3_HEIGHT = 88;

    public static final float CHARACTER_4_WIDTH = (float) 49.998;
    public static final float CHARACTER_4_HEIGHT = 88;

    public static final float CHARACTER_5_WIDTH = (float) 49.998;
    public static final float CHARACTER_5_HEIGHT = 88;

    public static final float CHARACTER_6_WIDTH = 50;
    public static final float CHARACTER_6_HEIGHT = 88;

    public static final float CHARACTER_7_WIDTH = (float) 43.895;
    public static final float CHARACTER_7_HEIGHT = 88;

    public static final float CHARACTER_8_WIDTH = 50;
    public static final float CHARACTER_8_HEIGHT = 88;

    public static final float CHARACTER_9_WIDTH = 50;
    public static final float CHARACTER_9_HEIGHT = 88;

    public static final float CHARACTER_FH_WIDTH = 36;
    public static final float CHARACTER_FH_HEIGHT = 11;

    public static final float CHARACTER_MH_WIDTH = 10;
    public static final float CHARACTER_MH_HEIGHT = 51;

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
    public static List<VectorDrawableModel> getTemperatureVDListByTemp(Context context,int temp) {

        int tintColor = getColorResourceByData(context,temp);
        String[] characters = getCharactersByData(temp);
        List<VectorDrawableModel> temperatureVDList = new ArrayList<>();
        VectorDrawableModel vectorDrawableModel = null;

        for (int i = 0; i < characters.length; i++) {
            vectorDrawableModel = getVectorDrawableByString(context,characters[i]);
            vectorDrawableModel.vectorDrawableCompat.setTint(tintColor);
            temperatureVDList.add(vectorDrawableModel);
        }
        return temperatureVDList;
    }

    /**
     * 获取时间VectorDrawable集合
     * @param context
     * @param datetime
     * @return
     */
    public static List<VectorDrawableModel> getDateTimeVDListByTemp(Context context,String datetime){

        String[] characters = getCharactersByDataTime(datetime);
        List<VectorDrawableModel> dateTimeVDList = new ArrayList<>();
        VectorDrawableModel vectorDrawableModel = null;

        for (int i = 0; i < characters.length; i++) {
            vectorDrawableModel = getVectorDrawableByString(context,characters[i]);
            dateTimeVDList.add(vectorDrawableModel);
        }

        return dateTimeVDList;
    }

    /**
     * 根据传入的字符串，返回VectorDrawable对象
     * @param context
     * @param character
     * @return
     */
    public static VectorDrawableModel getVectorDrawableByString(Context context,String character) {

        VectorDrawableModel vectorDrawableModel = new VectorDrawableModel();

        switch (character) {
            case CHARACTER_0:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_0_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_0_WIDTH;
                vectorDrawableModel.height = CHARACTER_0_HEIGHT;
                break;
            case CHARACTER_1:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_1_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_1_WIDTH;
                vectorDrawableModel.height = CHARACTER_1_HEIGHT;
                break;
            case CHARACTER_2:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_2_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_2_WIDTH;
                vectorDrawableModel.height = CHARACTER_2_HEIGHT;
                break;
            case CHARACTER_3:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_3_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_3_WIDTH;
                vectorDrawableModel.height = CHARACTER_3_HEIGHT;
                break;
            case CHARACTER_4:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_4_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_4_WIDTH;
                vectorDrawableModel.height = CHARACTER_4_HEIGHT;
                break;
            case CHARACTER_5:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_5_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_5_WIDTH;
                vectorDrawableModel.height = CHARACTER_5_HEIGHT;
                break;
            case CHARACTER_6:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_6_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_6_WIDTH;
                vectorDrawableModel.height = CHARACTER_6_HEIGHT;
                break;
            case CHARACTER_7:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_7_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_7_WIDTH;
                vectorDrawableModel.height = CHARACTER_7_HEIGHT;
                break;
            case CHARACTER_8:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_8_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_8_WIDTH;
                vectorDrawableModel.height = CHARACTER_8_HEIGHT;
                break;
            case CHARACTER_9:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_9_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_9_WIDTH;
                vectorDrawableModel.height = CHARACTER_9_HEIGHT;
                break;
            case CHARACTER_FH:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_fh_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_FH_WIDTH;
                vectorDrawableModel.height = CHARACTER_FH_HEIGHT;
                break;
            case CHARACTER_MH:
                vectorDrawableModel.vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(), R.drawable.shuzi_mh_img,context.getTheme());
                vectorDrawableModel.width = CHARACTER_MH_WIDTH;
                vectorDrawableModel.height = CHARACTER_MH_HEIGHT;
                break;
        }
        return vectorDrawableModel;
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

    public static String[] getCharactersByDataTime(String datatime){

        char[] chars = datatime.toCharArray();
        String[] characters = new String[chars.length];

        for (int i = 0; i < chars.length; i++) {
            characters[i] = Character.toString(chars[i]);
        }
        return characters;
    }
}
