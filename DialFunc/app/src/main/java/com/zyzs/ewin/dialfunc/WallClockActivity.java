package com.zyzs.ewin.dialfunc;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.zyzs.ewin.dialfunc.widget.clock.ClockView;
import com.zyzs.ewin.dialfunc.widget.clock.ItemModel;
import java.util.ArrayList;
import java.util.List;

public class WallClockActivity extends Activity {

    private ImageView imgBack;
    private ClockView wallClock;
    private List<ItemModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_clock);

        initView();
        initData();
        addEventListener();
    }

    private void initView(){
        imgBack = findViewById(R.id.img_back);
        wallClock = findViewById(R.id.wallClock);
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
        list.add(new ItemModel(220,220,118,14,7,getResources().getColor(R.color.c_50F5FF),220,220,"HOUR"));
        list.add(new ItemModel(220,220,170,14,7,getResources().getColor(R.color.c_64FF96),220,220,"MINUTE"));
        list.add(new ItemModel(190,220,250,2,0,getResources().getColor(R.color.c_FF5050),220,220,"SECOND"));
        list.add(new ItemModel(220,220,15,getResources().getColor(R.color.c_FFC864),"CIRCLE"));
        list.add(new ItemModel(220,220,10,getResources().getColor(R.color.c_FF5050),"CIRCLE"));

        wallClock.setItemList(list);
        wallClock.setBackImage(((BitmapDrawable) getResources().getDrawable(R.drawable.daiji_yuanpan_img)).getBitmap());
        wallClock.start();
    }
}
