package com.skibin.lab4;

public class TableBox {

    private String name;
    private int[] position = new int[2];

    public TableBox() { }

    public TableBox(String name, int y, int x) {
        this.name = name;
        position[0] = y;
        position[1] = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
}
