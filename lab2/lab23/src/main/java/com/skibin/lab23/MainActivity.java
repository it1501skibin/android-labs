package com.skibin.lab23;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etX, etY;
    TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etX = findViewById(R.id.etX);
        etY = findViewById(R.id.etY);
        tvRes = findViewById(R.id.tvRes);
    }

    public void onBtnClick(View view) {
        double X = Double.parseDouble(etX.getText().toString());
        double Y = Double.parseDouble(etY.getText().toString());
        double res = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
        String sqr = getResources().getString(R.string.sqr_root);
        //tvRes.setText("Расстояние до начала координат:\n" + sqr + "" Double.toString(X) + Double.toString(res));
        tvRes.setText(String.format("Расстояние до начала координат:\n %s(%.2f^2 + %.2f^2) = %.2f", sqr, X, Y, res));
    }
}
