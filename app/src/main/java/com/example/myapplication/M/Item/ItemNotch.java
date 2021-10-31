package com.example.myapplication.M.Item;


public class ItemNotch {
    private Boolean icon1;
    private String title1;
    private Boolean icon2;
    private String title2;

    public ItemNotch(Boolean icon1, String title1, Boolean icon2, String title2) {
        this.icon1 = icon1;
        this.title1 = title1;
        this.icon2 = icon2;
        this.title2 = title2;
    }

    public Boolean getIcon1() {
        return icon1;
    }

    public void setIcon1(Boolean icon1) {
        this.icon1 = icon1;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public Boolean getIcon2() {
        return icon2;
    }

    public void setIcon2(Boolean icon2) {
        this.icon2 = icon2;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }
}
