package com.skibin.lab4;

import java.util.ArrayList;
import java.util.Collections;

public class PuzzleGame {

    private TableBox[][] boxes;
    private ArrayList nums;
    private TableBox nullBox;
    private TableBox chosenBox = new TableBox();
    private boolean isConfigMode = false;
    private boolean lastMoveSuccess = false;

    public TableBox getChosenBox() {
        return chosenBox;
    }

    public TableBox getNullBox() {
        return nullBox;
    }
    public void setNullBox(TableBox nullBox) {
        this.nullBox = nullBox;
    }

    public TableBox[][] createBoxes() {
        boxes = new TableBox[4][4];
        initNums();

        for (int i = 0, it = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++, it++) {
                if(nums.get(it) != null)
                    boxes[i][j] = new TableBox(nums.get(it).toString(), i, j);
                else {
                    boxes[i][j] = new TableBox(null, i, j);
                    nullBox = boxes[i][j];
                }
            }
        }
        return boxes;
    }

    public ArrayList<ArrayList> getMoves() {
        ArrayList<ArrayList> moves = new ArrayList<>();
        boolean canMoveLeft = nullBox.getPosition()[1] > 0;
        boolean canMoveRight = nullBox.getPosition()[1] < 3;
        boolean canMoveUp = nullBox.getPosition()[0] > 0;
        boolean canMoveDown = nullBox.getPosition()[0] < 3;

        if(canMoveLeft) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nullBox.getPosition()[0]);
            list.add(nullBox.getPosition()[1] - 1);
            moves.add(list);
        }

        if(canMoveRight) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nullBox.getPosition()[0]);
            list.add(nullBox.getPosition()[1] + 1);
            moves.add(list);
        }

        if(canMoveUp) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nullBox.getPosition()[0] - 1);
            list.add(nullBox.getPosition()[1]);
            moves.add(list);
        }

        if(canMoveDown) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nullBox.getPosition()[0] + 1);
            list.add(nullBox.getPosition()[1]);
            moves.add(list);
        }
        return moves;
    }

    public void updateConfiguration(TableBox[][] boxes) {
        this.boxes = boxes;
    }

    public TableBox[][] makeMove(int chosenY, int chosenX) {
        int nullY = nullBox.getPosition()[0];
        int nullX = nullBox.getPosition()[1];

        if(isConfigMode) {
            boxes[nullY][nullX].setName(boxes[chosenY][chosenX].getName());
            boxes[chosenY][chosenX].setName(null);
            nullBox = boxes[chosenY][chosenX];

            chosenBox.setPosition(new int[]{nullY, nullX});
            lastMoveSuccess = false;
        }
        else if(checkMove(chosenY, chosenX)) {
            boxes[nullY][nullX].setName(boxes[chosenY][chosenX].getName());
            boxes[chosenY][chosenX].setName(null);
            nullBox = boxes[chosenY][chosenX];

            chosenBox.setPosition(new int[]{nullY, nullX});
            lastMoveSuccess = true;
        }
        else {
            chosenBox.setPosition(new int[] {chosenY, chosenX});
            lastMoveSuccess = false;
        }

        return boxes;
    }

    public boolean checkMove(int chosenY, int chosenX) {
        int lastNullY = nullBox.getPosition()[0];
        int lastNullX = nullBox.getPosition()[1];

        boolean fromLeft = ((lastNullX - chosenX) == 1) && (lastNullY == chosenY);
        boolean fromRight = ((chosenX - lastNullX) == 1) && (lastNullY == chosenY);
        boolean fromUp = ((lastNullY - chosenY) == 1) && (lastNullX == chosenX);
        boolean fromDown = ((chosenY - lastNullY) == 1) && (lastNullX == chosenX);

        if (fromLeft || fromRight || fromUp || fromDown)
            return true;
        return false;
    }

    private void initNums() {
        nums = new ArrayList();
        for (int i = 1; i < 16; i++)
            nums.add(i);
        nums.add(null);
        Collections.shuffle(nums);
    }

    public void setConfigMode(boolean configMode) {
        isConfigMode = configMode;
    }

    public boolean isConfigMode() {
        return isConfigMode;
    }

    public boolean isLastMoveSuccess() {
        return lastMoveSuccess;
    }

    public void setLastMoveSuccess(boolean lastMoveSuccess) {
        this.lastMoveSuccess = lastMoveSuccess;
    }
}
