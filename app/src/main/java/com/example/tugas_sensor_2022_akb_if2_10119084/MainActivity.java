package com.example.tugas_sensor_2022_akb_if2_10119084;
/**
 * Muhammad Idris Merdefi
 * 10119084
 * IF2
 */
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.example.tugas_sensor_2022_akb_if2_10119084.maps.MapsMyLoc;
import com.example.tugas_sensor_2022_akb_if2_10119084.maps.MapsResto;
import com.example.tugas_sensor_2022_akb_if2_10119084.ui.About;
import com.example.tugas_sensor_2022_akb_if2_10119084.ui.Profile;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    AnimatedBottomBar animatedBottomBar;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        animatedBottomBar = findViewById(R.id.animatedBottomBar);

        if (savedInstanceState==null){
            animatedBottomBar.selectTabById(R.id.navigation_food, true);
            fragmentManager = getSupportFragmentManager();
            MapsResto mapsResto = new MapsResto();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, mapsResto)
                    .commit();
        }

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NonNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()){
                    case  R.id.navigation_home:
                        fragment = new Profile();
                        break;
                    case R.id.navigation_food:
                        fragment = new MapsResto();
                        break;
                    case R.id.navigation_locatio_user:
                        fragment = new MapsMyLoc();
                        break;
                    case  R.id.navigation_about:
                        fragment = new About();
                        break;
                }

                if (fragment != null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                            .commit();
                }else{
                    Log.e(TAG, "Error in creating fragment");
                }
            }

            @Override
            public void onTabReselected(int lastIndex, @NonNull AnimatedBottomBar.Tab lastTab) {

            }
        });
    }
}