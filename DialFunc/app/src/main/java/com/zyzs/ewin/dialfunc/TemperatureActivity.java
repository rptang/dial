package com.zyzs.ewin.dialfunc;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.zyzs.ewin.dialfunc.utils.VectorDrawableModel;
import com.zyzs.ewin.dialfunc.utils.VectorDrawableUtils;
import java.util.List;

public class TemperatureActivity extends Activity {

    private ImageView imgBack;
    private LinearLayout llTempInner,llTempOuter;
    private float textSizePenc = (float) 0.4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        initView();
        initData();
        addEventListener();
    }

    private void initView(){
        imgBack = findViewById(R.id.img_back);
        llTempInner = findViewById(R.id.ll_temp_inner);
        llTempOuter = findViewById(R.id.ll_temp_outer);
    }

    private void addEventListener(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData(){

        List<VectorDrawableModel> innerTempVDList = VectorDrawableUtils.getTemperatureVDListByTemp(this,22);

        if(innerTempVDList.size() != 0){

            llTempInner.removeAllViews(); //拿到数据后，先移除默认的UI

            for (int i = 0; i < innerTempVDList.size(); i++) {

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                AppCompatImageView charView = new AppCompatImageView(this); //新建AppCompatImageView
                lp.width = (int) (innerTempVDList.get(i).width * textSizePenc);
                lp.height = (int) (innerTempVDList.get(i).height * textSizePenc);
                lp.setMargins(0,0,3,0);
                charView.setLayoutParams(lp);
                charView.setImageDrawable(innerTempVDList.get(i).vectorDrawableCompat);
                llTempInner.addView(charView);
            }

            ImageView tempUnit = new ImageView(this); //新建温度单位ImageView
            LinearLayout.LayoutParams tempUnitParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            tempUnitParams.gravity = Gravity.BOTTOM;
            tempUnit.setLayoutParams(tempUnitParams);
            tempUnit.setImageDrawable(getResources().getDrawable(R.drawable.wendu_dw_img));
            llTempInner.addView(tempUnit);
        }

        List<VectorDrawableModel> outerTempVDList = VectorDrawableUtils.getTemperatureVDListByTemp(this,-5);

        if(outerTempVDList.size() != 0){

            llTempOuter.removeAllViews(); //拿到数据后，先移除默认的UI

            for (int i = 0; i < outerTempVDList.size(); i++) {

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                AppCompatImageView charView = new AppCompatImageView(this); //新建AppCompatImageView
                lp.width = (int) (outerTempVDList.get(i).width * textSizePenc);
                lp.height = (int) (outerTempVDList.get(i).height * textSizePenc);
                lp.gravity = Gravity.CENTER_VERTICAL;
                lp.setMargins(0,0,3,0);
                charView.setLayoutParams(lp);
                charView.setImageDrawable(outerTempVDList.get(i).vectorDrawableCompat);
                llTempOuter.addView(charView);
            }

            ImageView tempUnit = new ImageView(this); //新建温度单位ImageView
            LinearLayout.LayoutParams tempUnitParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            tempUnitParams.gravity = Gravity.BOTTOM;
            tempUnit.setLayoutParams(tempUnitParams);
            tempUnit.setImageDrawable(getResources().getDrawable(R.drawable.wendu_dw_img));
            llTempOuter.addView(tempUnit);
        }
    }
}
