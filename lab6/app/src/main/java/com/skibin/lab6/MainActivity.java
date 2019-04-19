package com.skibin.lab6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String ROWS_NUM = "com.skibin.lab6.ROWS_NUM";
    public final static String COLUMNS_NUM = "com.skibin.lab6.COLUMNS_NUM";
    public final static String FILL_RANDOM = "com.skibin.lab6.FILL_RANDOM";
    EditText etRowsNum, etColumnsNum;
    CheckBox chbFillRandom;
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRowsNum = findViewById(R.id.etRowsNum);
        etColumnsNum = findViewById(R.id.etColumnsNum);
        chbFillRandom = findViewById(R.id.chbFillRandom);
        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        boolean fillRandom = false;
        switch (view.getId()) {
            case R.id.btnCreate:
                intent = new Intent(this, MatrixActivity.class);
                int rows, columns;
                if(!etRowsNum.getText().toString().equals("") && !etColumnsNum.getText().toString().equals("")) {
                    rows = Integer.parseInt(etRowsNum.getText().toString());
                    columns = Integer.parseInt(etColumnsNum.getText().toString());

                    if(rows <= 0 || columns <= 0) {
                        Toast.makeText(this, "Количество должно быть положительным!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(chbFillRandom.isChecked())
                            fillRandom = true;
                        intent.putExtra(ROWS_NUM, rows);
                        intent.putExtra(COLUMNS_NUM, columns);
                        intent.putExtra(FILL_RANDOM, fillRandom);
                        startActivity(intent);
                    }
                }
                else Toast.makeText(this, "Введите значения!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
