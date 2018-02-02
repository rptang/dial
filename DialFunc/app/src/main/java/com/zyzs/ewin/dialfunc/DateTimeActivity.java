package com.zyzs.ewin.dialfunc;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zyzs.ewin.dialfunc.utils.VectorDrawableModel;
import com.zyzs.ewin.dialfunc.utils.VectorDrawableUtils;
import com.zyzs.ewin.dialfunc.widget.LiquidNumberText;
import com.zyzs.ewin.dialfunc.widget.TimeClockView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateTimeActivity extends Activity {

    private ImageView imgBack;
    private TimeClockView timeClockView;
    private TextView tvDate;
    private LinearLayout llDatetime;
    private float textSizePenc = (float) 0.6;

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
        llDatetime = findViewById(R.id.ll_datetime);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/方正兰亭纤黑简体.ttf");
        tvDate.setTypeface(tf);
    }

    private void addEventListener(){

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        timeClockView.setUpdateDateListener(new TimeClockView.UpdateDateListener() {
            @Override
            public void update(final Date date) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
                        tvDate.setText(format.format(date));

                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                        List<VectorDrawableModel> dateTimeVDList = VectorDrawableUtils.getDateTimeVDListByTemp(DateTimeActivity.this,timeFormat.format(date));

                        if(dateTimeVDList.size() != 0){

                            llDatetime.removeAllViews(); //拿到数据后，先移除默认的UI

                            for (int i = 0; i < dateTimeVDList.size(); i++) {

                                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                        ViewGroup.LayoutParams.WRAP_CONTENT);

                                AppCompatImageView charView = new AppCompatImageView(DateTimeActivity.this); //新建AppCompatImageView
                                lp.width = (int) (dateTimeVDList.get(i).width * textSizePenc);
                                lp.height = (int) (dateTimeVDList.get(i).height * textSizePenc);
                                lp.gravity = Gravity.CENTER_VERTICAL;
                                lp.setMargins(0,0,3,0);
                                charView.setLayoutParams(lp);
                                charView.setImageDrawable(dateTimeVDList.get(i).vectorDrawableCompat);
                                llDatetime.addView(charView);
                            }
                        }
                    }
                });
            }
        });
    }

    private void initData(){

        timeClockView.start();
    }
}
