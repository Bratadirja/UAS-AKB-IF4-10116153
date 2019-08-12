package com.example.andikabratadirja.biodata.model;

import android.support.v4.app.Fragment;

public interface IFragmentAdapter {
    void add(Fragment Frag, String Title);
    Fragment getItem(int position);
    CharSequence getPageTitle(int position);
    int getCount();
}
