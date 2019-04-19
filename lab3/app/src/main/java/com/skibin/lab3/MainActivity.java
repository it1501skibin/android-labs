package com.skibin.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mCrows, mCats;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
    }

    public void onHelloClick(View view) {
        tv.setText("Привет!");
    }

    public void onCrowsClick(View view) {
        tv.setText("Я насчитал " + (++mCrows) + " ворон");
    }

    public void onCatsClick(View view) {
        tv.setText("Я насчитал " + (++mCats) + " котов");
    }
}
