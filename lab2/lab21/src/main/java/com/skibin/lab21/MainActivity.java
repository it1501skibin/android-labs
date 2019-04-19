package com.skibin.lab21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button hideBtn, showBtn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideBtn = findViewById(R.id.hideBtn);
        hideBtn.setOnClickListener(this);
        showBtn = findViewById(R.id.showBtn);
        showBtn.setOnClickListener(this);

        tv = findViewById(R.id.TV);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.showBtn:
                tv.setText("Text information");
                break;
            case R.id.hideBtn:
                tv.setText("");
                break;
        }
    }
}
