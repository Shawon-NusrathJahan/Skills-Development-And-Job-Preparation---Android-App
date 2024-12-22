package com.example.myapplication;

public class CardItem {
    private int imageResId;
    private int iconResId; // Icon resource ID
    private String title;

    public CardItem(int imageResId, int iconResId, String title) {
        this.imageResId = imageResId;
        this.iconResId = iconResId;
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getTitle() {
        return title;
    }
}


