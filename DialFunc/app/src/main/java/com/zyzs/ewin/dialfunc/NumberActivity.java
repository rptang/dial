package com.zyzs.ewin.dialfunc;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyzs.ewin.dialfunc.widget.LiquidNumberText;

public class NumberActivity extends Activity {

    private ImageView imgBack;
    private LiquidNumberText tvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        initView();
        initData();
        addEventListener();
    }

    private void initView(){
        imgBack = findViewById(R.id.img_back);
        tvNumber = findViewById(R.id.tv_number);
        //tvNumber.setTextSkewX(-0.5f);//float类型参数，负数表示右斜，整数左斜
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

    }
}
