package com.zyzs.ewin.dialfunc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity implements View.OnClickListener {

    private Button btnCompass,btnNumber,btnSvg,btnTemperature,btnPM2d5,btnWallClock,btnSpeedTable,btnDateTime;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initView();
        addEventListener();
    }

    private void initView(){
        btnCompass = findViewById(R.id.btn_compass);
        btnNumber = findViewById(R.id.btn_number);
        btnSvg = findViewById(R.id.btn_svg);
        btnTemperature = findViewById(R.id.btn_temperature);
        btnPM2d5 = findViewById(R.id.btn_pm2d5);
        btnWallClock = findViewById(R.id.btn_wall_clock);
        btnSpeedTable = findViewById(R.id.btn_speed_table);
        btnDateTime = findViewById(R.id.btn_date_time);
    }

    private void addEventListener(){
        btnCompass.setOnClickListener(this);
        btnNumber.setOnClickListener(this);
        btnSvg.setOnClickListener(this);
        btnTemperature.setOnClickListener(this);
        btnPM2d5.setOnClickListener(this);
        btnWallClock.setOnClickListener(this);
        btnSpeedTable.setOnClickListener(this);
        btnDateTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_compass:
                mIntent = new Intent(this,CompassActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_number:
                mIntent = new Intent(this,NumberActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_svg:
                mIntent = new Intent(this,SVGActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_temperature:
                mIntent = new Intent(this,TemperatureActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_pm2d5:
                mIntent = new Intent(this,PM2d5Activity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_wall_clock:
                mIntent = new Intent(this,WallClockActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_speed_table:
                mIntent = new Intent(this,SpeedometerActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_date_time:
                mIntent = new Intent(this,DateTimeActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}
