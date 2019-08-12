package com.example.andikabratadirja.biodata.view.viewPager;

/*

 Tanggal Pengerjaan : 11-08-2019
 NIM : 10116153
 NAMA : Andika Bratadirja SJ
 KELAS : IF - 4

 */

public class ScreenItem {
    private String Title;
    private String Description;
    private int ScreenImg;

    public ScreenItem(String title, String description, int screenImg){
        Title = title;
        Description = description;
        ScreenImg = screenImg;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }
}
