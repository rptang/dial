package com.zyzs.ewin.dialfunc;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zyzs.ewin.dialfunc.widget.LiquidNumberText;
import com.zyzs.ewin.dialfunc.widget.SpeedView;

public class SpeedometerActivity extends Activity {

    private ImageView imgBack;
    private SeekBar speedSeekBar;
    private SpeedView speedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speedometer);

        initView();
        initData();
        addEventListener();
    }

    private void initView(){
        imgBack = findViewById(R.id.img_back);
        speedSeekBar = findViewById(R.id.speed_seek_bar);
        speedView = findViewById(R.id.speed_view);
    }

    private void addEventListener(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        speedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int currSpeed, boolean b) {
                speedView.setCurrSpeed(currSpeed);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initData(){
        speedSeekBar.setProgress(0);
        speedView.setCurrSpeed(0);
    }
}
