package com.example.andikabratadirja.biodata;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.andikabratadirja.biodata.model.FragmentAdapter;
import com.example.andikabratadirja.biodata.model.Preferences;
import com.example.andikabratadirja.biodata.presenter.LoginActivity;
import com.example.andikabratadirja.biodata.presenter.fragment.FragmentKontak;
import com.example.andikabratadirja.biodata.presenter.fragment.FragmentProfile;
import com.example.andikabratadirja.biodata.presenter.fragment.FragmentTeman;

/*

 Tanggal Pengerjaan : 11-08-2019
 NIM : 10116153
 NAMA : Andika Bratadirja SJ
 KELAS : IF - 4

 */

public class MainActivity extends AppCompatActivity  {

    ViewPager viewPager;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager = findViewById(R.id.viewpager);
        setupFm(getSupportFragmentManager(),viewPager);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new PageChange());

    }

    public static void setupFm(FragmentManager fragmentManager, ViewPager viewPager){
        FragmentAdapter Adapter = new FragmentAdapter(fragmentManager);
        Adapter.add(new FragmentProfile(),"Page One");
        Adapter.add(new FragmentKontak(),"Page Two");
        Adapter.add(new FragmentTeman(),"Page Three");

        viewPager.setAdapter(Adapter);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new  BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.profil_menu:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.kontak_menu:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.teman_menu:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    public class PageChange implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position){
                case 0:
                    navigationView.setSelectedItemId(R.id.profil_menu);
                    break;
                case 1:
                    navigationView.setSelectedItemId(R.id.kontak_menu);
                    break;
                case 2:
                    navigationView.setSelectedItemId(R.id.teman_menu);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.log_out:
                Preferences.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
