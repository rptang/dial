package com.zyzs.ewin.dialfunc;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyzs.ewin.dialfunc.widget.LiquidNumberText;
import com.zyzs.ewin.dialfunc.widget.TimeClockView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeActivity extends Activity {

    private ImageView imgBack;
    private TimeClockView timeClockView;
    private TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        initView();
        initData();
        addEventListener();
    }

    private void initView(){
        imgBack = findViewById(R.id.img_back);
        timeClockView = findViewById(R.id.timeClockView);
        tvDate = findViewById(R.id.tv_date);
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
        timeClockView.start();
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/方正兰亭纤黑简体.ttf");
        tvDate.setTypeface(tf);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        tvDate.setText(format.format(date));
    }
}
