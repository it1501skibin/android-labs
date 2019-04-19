package com.skibin.lab22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button plusBtn, minusBtn, divBtn, multBtn;
    TextView resTV;
    EditText op1ET, op2ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusBtn = findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(this);
        minusBtn = findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(this);
        divBtn = findViewById(R.id.divBtn);
        divBtn.setOnClickListener(this);
        multBtn = findViewById(R.id.multBtn);
        multBtn.setOnClickListener(this);

        op1ET = findViewById(R.id.op1ET);
        op2ET = findViewById(R.id.op2ET);

        resTV = findViewById(R.id.resTV);
    }

    @Override
    public void onClick(View view) {
        double op1 = Double.parseDouble(op1ET.getText().toString());
        double op2 = Double.parseDouble(op2ET.getText().toString());
        double res = 0.0;
        switch (view.getId()) {
            case R.id.plusBtn:
                res = op1 + op2;
                break;
            case R.id.minusBtn:
                res = op1 - op2;
                break;
            case R.id.divBtn:
                res = op1 / op2;
                break;
            case R.id.multBtn:
                res = op1 * op2;
                break;
        }
        resTV.setText(Double.toString(res));
    }
}
