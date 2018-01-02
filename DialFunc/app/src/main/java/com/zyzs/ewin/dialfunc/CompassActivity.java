package com.zyzs.ewin.dialfunc;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class CompassActivity extends Activity implements SensorEventListener, View.OnClickListener {

    // 定义显示指南针图片的组件
    private ImageView imgCompassBG;
    // 记录指南针图片转过的角度
    private float currentDegree = 0f;
    // 定义真机的Sensor管理器
    private SensorManager mSensorManager;
    //定义返回按钮
    private ImageView imgBack;
    //定义当前角度
    private TextView tvDegree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);

        initService();
        initView();
        addEventListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 为系统的方向传感器注册监听器
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    private void initService(){
        // 获取真机的传感器管理服务
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    private void initView(){
        imgCompassBG = findViewById(R.id.img_compass_bg);
        imgBack = findViewById(R.id.img_back);
        tvDegree = findViewById(R.id.tv_degree);
    }

    private void addEventListener(){
        imgBack.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 取消注册
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // 如果真机上触发event的传感器类型为水平传感器类型
        if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
            // 获取绕Z轴转过的角度
            float degree = event.values[0];
            // 创建旋转动画（反向转过degree度）
            RotateAnimation ra = new RotateAnimation(currentDegree, -degree,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            // 设置动画的持续时间
            ra.setDuration(200);
            // 设置动画结束后的保留状态
            ra.setFillAfter(true);
            // 启动动画
            imgCompassBG.startAnimation(ra);
            currentDegree = -degree;
            tvDegree.setText(String.valueOf(Math.round(degree)));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
        }
    }
}
