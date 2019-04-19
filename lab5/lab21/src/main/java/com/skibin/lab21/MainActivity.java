package com.skibin.lab21;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String BACKGROUND_COLOR = "com.skibin.lab21.BACKGROUND_COLOR";
    public final static String TEXT_SIZE = "com.skibin.lab21.TEXT_SIZE";
    public final static String ACTIVITY_TITLE = "com.skibin.lab21.ACTIVITY_TITLE";
    Button hideBtn, showBtn, btnSettings;
    ConstraintLayout conLayout;
    static final private int SET_SETTINGS = 0;
    TextView tv;
    private int textSize = 14;
    private int color = R.color.colorWhite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideBtn = findViewById(R.id.hideBtn);
        hideBtn.setOnClickListener(this);
        showBtn = findViewById(R.id.showBtn);
        showBtn.setOnClickListener(this);
        btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(this);

        tv = findViewById(R.id.TV);
        conLayout = findViewById(R.id.conLayout);
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
            case R.id.btnSettings:
                Intent intent = new Intent(this, SettingsActivity.class);
                intent.putExtra(TEXT_SIZE, textSize);

                intent.putExtra(BACKGROUND_COLOR, color);

                intent.putExtra(ACTIVITY_TITLE, getTitle());
                startActivityForResult(intent, SET_SETTINGS);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SET_SETTINGS) {
            if (resultCode == RESULT_OK) {
                int colorId = data.getIntExtra(SettingsActivity.BACKGROUND_COLOR, R.color.colorWhite);
                conLayout.setBackgroundColor(getResources().getColor(colorId));
                color = colorId;

                switch (data.getIntExtra(SettingsActivity.TEXT_SIZE, 14)) {
                    case 14:
                        textSize = 14;
                        changeTextSize(textSize);
                        break;
                    case 20:
                        textSize = 20;
                        changeTextSize(textSize);
                        break;
                    case 25:
                        textSize = 25;
                        changeTextSize(textSize);
                        break;
                }

                String activityTitle = data.getStringExtra(SettingsActivity.ACTIVITY_TITLE);
                setTitle(activityTitle);
            }
        }

    }

    private void changeTextSize(float textSize) {
        showBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        hideBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btnSettings.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
    }
}
