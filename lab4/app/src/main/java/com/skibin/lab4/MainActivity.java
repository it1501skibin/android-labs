package com.skibin.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
    Button btnSave;
    int[][] buttons = {
            {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4},
            {R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8},
            {R.id.btn9, R.id.btn10, R.id.btn11, R.id.btn12},
            {R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16}
    };
    TableBox[][] boxes;
    PuzzleGame pg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn10 = findViewById(R.id.btn10);
        btn10.setOnClickListener(this);
        btn11 = findViewById(R.id.btn11);
        btn11.setOnClickListener(this);
        btn12 = findViewById(R.id.btn12);
        btn12.setOnClickListener(this);
        btn13 = findViewById(R.id.btn13);
        btn13.setOnClickListener(this);
        btn14 = findViewById(R.id.btn14);
        btn14.setOnClickListener(this);
        btn15 = findViewById(R.id.btn15);
        btn15.setOnClickListener(this);
        btn16 = findViewById(R.id.btn16);
        btn16.setOnClickListener(this);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg.setConfigMode(false);
                redrawBoxes(boxes);

                if(getNullBox() != null)
                    pg.setNullBox(getNullBox());

                btnSave.setVisibility(View.INVISIBLE);
            }
        });

        pg = new PuzzleGame();
        boxes = pg.createBoxes();
        redrawBoxes(boxes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shuffleMenuItem:
                pg.setConfigMode(false);
                boxes = pg.createBoxes();
                redrawBoxes(boxes);
                btnSave.setVisibility(View.INVISIBLE);
                return true;
            case R.id.changeMenuItem:
                pg.setConfigMode(true);
                clearBtnColor();
                btnSave.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void markMoves(ArrayList<ArrayList> moves) {
        clearBtnColor();
        for (int i = 0; i < moves.size(); i++) {
            for (int j = 0; j < moves.get(i).size(); j++) {
                Integer y = (Integer) moves.get(i).get(0);
                Integer x = (Integer) moves.get(i).get(1);

                Button btn = findViewById(buttons[y][x]);
                btn.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            }
        }
    }

    void clearBtnColor() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                Button btn = findViewById(buttons[i][j]);
                btn.setBackgroundResource(android.R.drawable.btn_default);
            }
        }
    }

    void redrawBoxes(TableBox[][] boxes) {
        Button btn;
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                btn = findViewById(buttons[i][j]);
                btn.setText(boxes[i][j].getName());
            }
        }
        if(!pg.isConfigMode())
            markMoves(pg.getMoves());
    }

    void markLastChosenBox() {
        int y = pg.getChosenBox().getPosition()[0];
        int x = pg.getChosenBox().getPosition()[1];
        Button btn = findViewById(buttons[y][x]);
        btn.setBackgroundColor(getResources().getColor(R.color.colorDarkOrange));
    }

    TableBox getNullBox() {
        TableBox nullBox;
        for (int i = 0; i < boxes.length; i++) {
            for(int j = 0; j < boxes[i].length; j++) {
                Button btn = findViewById(buttons[i][j]);
                if(btn.getText() == null) {
                    nullBox = new TableBox(null, i, j);
                    return nullBox;
                }
            }
        }
        return null;
    }

    @Override
    public void onClick(View v) {
        int y, x;
        switch (v.getId()) {
            case R.id.btn1:
                y = 0;
                x = 0;
                break;
            case R.id.btn2:
                y = 0;
                x = 1;
                break;
            case R.id.btn3:
                y = 0;
                x = 2;
                break;
            case R.id.btn4:
                y = 0;
                x = 3;
                break;
            case R.id.btn5:
                y = 1;
                x = 0;
                break;
            case R.id.btn6:
                y = 1;
                x = 1;
                break;
            case R.id.btn7:
                y = 1;
                x = 2;
                break;
            case R.id.btn8:
                y = 1;
                x = 3;
                break;
            case R.id.btn9:
                y = 2;
                x = 0;
                break;
            case R.id.btn10:
                y = 2;
                x = 1;
                break;
            case R.id.btn11:
                y = 2;
                x = 2;
                break;
            case R.id.btn12:
                y = 2;
                x = 3;
                break;
            case R.id.btn13:
                y = 3;
                x = 0;
                break;
            case R.id.btn14:
                y = 3;
                x = 1;
                break;
            case R.id.btn15:
                y = 3;
                x = 2;
                break;
            case R.id.btn16:
                y = 3;
                x = 3;
                break;
            default:
                y = -1;
                x = -1;
        }

        redrawBoxes(pg.makeMove(y, x));

        if(!pg.isConfigMode() && pg.isLastMoveSuccess())
            markLastChosenBox();
    }
}
