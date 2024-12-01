// ChecklistItem.java
package com.example.myapplication;

public class ChecklistItem {
    private String text;
    private boolean isChecked;

    // Constructor
    public ChecklistItem(String text, boolean isChecked) {
        this.text = text;
        this.isChecked = isChecked;
    }

    // Getter and Setter for text
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // Getter and Setter for isChecked
    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
