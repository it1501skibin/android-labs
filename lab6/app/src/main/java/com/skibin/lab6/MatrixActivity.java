package com.skibin.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Arrays;

public class MatrixActivity extends AppCompatActivity {

    TableLayout tableLayout;
    int defRowsNum = 3;
    int defColumnsNum = 3;
    Matrix matrix;
    EditText[][] editTexts;
    private static final String KEY_MATRIX = "MATRIX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        tableLayout = findViewById(R.id.tableLayout);
        tableLayout.setStretchAllColumns(true);

        if(savedInstanceState != null) {
            int[][] matrixArray = (int[][])savedInstanceState.getSerializable(KEY_MATRIX);
            matrix = new Matrix(matrixArray.length, matrixArray[0].length);
            matrix.setMatrixArray(matrixArray);
            editTexts = new EditText[matrix.getRowsNum()][matrix.getColumnsNum()];
            fillMatrixGui(matrix.getMatrixArray());
        }
        else {
            int rows = getIntent().getIntExtra(MainActivity.ROWS_NUM, defRowsNum);
            int columns = getIntent().getIntExtra(MainActivity.COLUMNS_NUM, defColumnsNum);
            boolean fillRandom = getIntent().getBooleanExtra(MainActivity.FILL_RANDOM, false);

            matrix = new Matrix(rows, columns);
            if(fillRandom)
                matrix.fillMatrixRandomly();

            editTexts = new EditText[matrix.getRowsNum()][matrix.getColumnsNum()];
            fillMatrixGui(matrix.getMatrixArray());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable(KEY_MATRIX, getCurMatrixArray());
    }

    private int[][] getCurMatrixArray() {
        int[][] matrixArray = new int[editTexts.length][editTexts[0].length];
        for(int i = 0; i < editTexts.length; i++) {
            for(int j = 0; j < editTexts[i].length; j++) {
                matrixArray[i][j] = Integer.parseInt(editTexts[i][j].getText().toString());
            }
        }
        return matrixArray;
    }

    private void fillMatrixGui(int[][] matrixArray) {
        for(int i = 0; i < matrixArray.length; i++) {
            TableRow tRow = new TableRow(this);
            for(int j = 0; j < matrixArray[i].length; j++) {
                EditText et = new EditText(this);
                et.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
                et.setText(String.valueOf(matrixArray[i][j]));
                editTexts[i][j] = et;
                tRow.addView(et);
            }
            tableLayout.addView(tRow);
        }
    }


    public void onBtnAverageClick(View view) {
        matrix.setMatrixArray(getCurMatrixArray());
        Toast.makeText(this, "Ср. арифм: " + String.valueOf(matrix.getAverage()), Toast.LENGTH_SHORT).show();
    }
}
