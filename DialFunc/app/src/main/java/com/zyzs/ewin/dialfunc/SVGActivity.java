package com.zyzs.ewin.dialfunc;

import android.app.Activity;
import android.os.Bundle;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SVGActivity extends Activity {

    private ImageView imgBack;
    private ImageView eight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);

        initView();
        initData();
        addEventListener();
    }

    private void initView(){
        imgBack = findViewById(R.id.img_back);
        eight = findViewById(R.id.eight);
    }

    private void initData(){
        VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.create(getResources(),R.drawable.svg8,getTheme());
        vectorDrawableCompat.setTint(getResources().getColor(R.color.colorPrimary));
        ViewGroup.LayoutParams params;
        params = eight.getLayoutParams();
        params.width = 300;
        params.height = 300;
        eight.setLayoutParams(params);
        eight.setImageDrawable(vectorDrawableCompat);
    }

    private void addEventListener(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
