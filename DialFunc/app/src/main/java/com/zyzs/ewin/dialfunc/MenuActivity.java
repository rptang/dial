package com.zyzs.ewin.dialfunc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity implements View.OnClickListener {

    private Button btnCompass,btnNumber;
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
    }

    private void addEventListener(){
        btnCompass.setOnClickListener(this);
        btnNumber.setOnClickListener(this);
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
        }
    }
}
