package net.odiak.recyclerviewtest;


import android.graphics.Color;

public class Item {
    private String mTitle;
    private int mColor;

    public Item(String title) {
        mTitle = title;
        mColor = Color.HSVToColor(new float[]{(float)(Math.random() * 12) * 30, 0.2f, 1f});
    }

    public String getTitle() { return mTitle; }
    public int getColor() { return mColor; }
}
