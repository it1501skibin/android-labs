package com.skibin.lab21;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String BACKGROUND_COLOR = "com.skibin.lab21.BACKGROUND_COLOR";
    public final static String TEXT_SIZE = "com.skibin.lab21.TEXT_SIZE";
    public final static String ACTIVITY_TITLE = "com.skibin.lab21.ACTIVITY_TITLE";

    RadioButton rbBackgroundWhite, rbBackgroundBlue, rbBackgroundGreen;
    RadioGroup rgBackgroundColor;
    RadioButton rbTextSize14sp, rbTextSize20sp, rbTextSize25sp;
    RadioGroup rgTextSize;
    EditText etActivityTitle;
    Button btnSave;
    TextView tvBackgroundColor, tvTextSize, tvActivityTitle;
    LinearLayout linLayout;
    Intent answerIntent = new Intent();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        rbBackgroundWhite = findViewById(R.id.rbBackgroundWhite);
        rbBackgroundWhite.setOnClickListener(this);
        rbBackgroundBlue = findViewById(R.id.rbBackgroundBlue);
        rbBackgroundBlue.setOnClickListener(this);
        rbBackgroundGreen = findViewById(R.id.rbBackgroundGreen);
        rbBackgroundGreen.setOnClickListener(this);
        rbTextSize14sp = findViewById(R.id.rbTextSize14sp);
        rbTextSize14sp.setOnClickListener(this);
        rbTextSize20sp = findViewById(R.id.rbTextSize20sp);
        rbTextSize20sp.setOnClickListener(this);
        rbTextSize25sp = findViewById(R.id.rbTextSize25sp);
        rbTextSize25sp.setOnClickListener(this);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        etActivityTitle = findViewById(R.id.etActivityTitle);
        tvBackgroundColor = findViewById(R.id.tvBackgroundColor);
        tvTextSize = findViewById(R.id.tvTextSize);
        tvActivityTitle = findViewById(R.id.tvActivityTitle);
        rgTextSize = findViewById(R.id.rgTextSize);
        rgBackgroundColor = findViewById(R.id.rgBackgroundColor);
        linLayout = findViewById(R.id.linLayout);

        setTitle(getIntent().getStringExtra(MainActivity.ACTIVITY_TITLE));
        etActivityTitle.setText(getIntent().getStringExtra(MainActivity.ACTIVITY_TITLE));

        changeTextSize(getIntent().getIntExtra(MainActivity.TEXT_SIZE, 14));
        linLayout.setBackgroundColor(getResources().getColor(getIntent().getIntExtra(MainActivity.BACKGROUND_COLOR, R.color.colorWhite)));

        setRadioButtons(getIntent());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                int rbId = rgBackgroundColor.getCheckedRadioButtonId();
                switch (rbId) {
                    case R.id.rbBackgroundWhite:
                        answerIntent.putExtra(BACKGROUND_COLOR, R.color.colorWhite);
                        break;
                    case R.id.rbBackgroundBlue:
                        answerIntent.putExtra(BACKGROUND_COLOR, R.color.colorBlue);
                        break;
                    case R.id.rbBackgroundGreen:
                        answerIntent.putExtra(BACKGROUND_COLOR, R.color.colorGreen);
                        break;
                }

                rbId = rgTextSize.getCheckedRadioButtonId();
                switch (rbId) {
                    case R.id.rbTextSize14sp:
                        answerIntent.putExtra(TEXT_SIZE, 14);
                        break;
                    case R.id.rbTextSize20sp:
                        answerIntent.putExtra(TEXT_SIZE, 20);
                        break;
                    case R.id.rbTextSize25sp:
                        answerIntent.putExtra(TEXT_SIZE, 25);
                        break;
                }

                if(etActivityTitle.getText().toString().length() > 0)
                    answerIntent.putExtra(ACTIVITY_TITLE, etActivityTitle.getText().toString());
                setResult(RESULT_OK, answerIntent);
                finish();
                break;
        }
    }

    private void changeTextSize(float textSize) {
        tvActivityTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        tvTextSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        tvBackgroundColor.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        rbBackgroundBlue.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        rbBackgroundGreen.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        rbBackgroundWhite.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        rbTextSize14sp.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        rbTextSize20sp.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        rbTextSize25sp.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        etActivityTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btnSave.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
    }

    private void setRadioButtons(Intent intent) {
        int colorId = intent.getIntExtra(MainActivity.BACKGROUND_COLOR, R.color.colorWhite);
        RadioButton curRB;
        switch (colorId) {
            case R.color.colorWhite:
                curRB = rbBackgroundWhite;
                break;
            case R.color.colorBlue:
                curRB = rbBackgroundBlue;
                break;
            case R.color.colorGreen:
                curRB = rbBackgroundGreen;
                break;
            default:
                curRB = rbBackgroundWhite;
                break;
        }
        rgBackgroundColor.check(curRB.getId());


        int textSize = intent.getIntExtra(MainActivity.TEXT_SIZE, 10);
        switch (textSize) {
            case 14:
                curRB = rbTextSize14sp;
                break;
            case 20:
                curRB = rbTextSize20sp;
                break;
            case 25:
                curRB = rbTextSize25sp;
                break;
            default:
                curRB = rbTextSize14sp;
        }
        rgTextSize.check(curRB.getId());
    }
}
