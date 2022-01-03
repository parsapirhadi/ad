package com.example.myapplication.M.Item;

public class ItemMontageEditor {



    private String icon;
    private String title_start;
    private String title_end;


    public String getIcon() {
        return icon;
    }


    public String getTitle_Start() {
        return title_start;
    }
    public String getTitle_End() {
        return title_end;
    }

    public ItemMontageEditor(String icon, String title_start, String title_end) {
        this.icon = icon;
        this.title_start= title_start;
        this.title_end= title_end;


    }

}
