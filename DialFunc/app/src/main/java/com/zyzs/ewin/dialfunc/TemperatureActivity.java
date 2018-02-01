package com.zyzs.ewin.dialfunc;

import android.app.Activity;
import android.os.Bundle;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

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

        List<VectorDrawableCompat> innerTempVDList = VectorDrawableUtils.getTemperatureVDListByTemp(this,11);

        if(innerTempVDList.size() != 0){

            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            llTempInner.removeAllViews(); //拿到数据后，先移除默认的UI

            for (int i = 0; i < innerTempVDList.size(); i++) {

                ViewGroup.LayoutParams params;
                AppCompatImageView charView = new AppCompatImageView(this); //新建AppCompatImageView
                charView.setLayoutParams(lp);
                charView.setImageDrawable(innerTempVDList.get(i)); //放资源后，可以拿到AppCompatImageView的LayoutParams
                llTempInner.addView(charView);//没放资源之前，不知道AppCompatImageView有多大
                params = charView.getLayoutParams();
                params.width = (int) (params.width * textSizePenc);
                params.height = (int) (params.height * textSizePenc);
                System.out.println("params.width="+params.width);
                System.out.println("params.height="+params.height);
//                charView.setLayoutParams(params);
            }

            AppCompatImageView childView;
            ViewGroup.LayoutParams params;
            for (int i = 0; i < llTempInner.getChildCount(); i++) {
                childView = (AppCompatImageView) llTempInner.getChildAt(i);
                params = childView.getLayoutParams();
                params.width = (int) (params.width * textSizePenc);
                params.height = (int) (params.height * textSizePenc);
//                System.out.println("params.width="+params.width);
//                System.out.println("params.height="+params.height);
                childView.setLayoutParams(params);
                childView.setImageDrawable(innerTempVDList.get(i));
            }
        }
    }
}
