package com.example.smd_assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class home_activity extends AppCompatActivity {
 FrameLayout frameLayout;
 TabLayout tabLayout;
    ImageView backArrowImageView, profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        profile=findViewById(R.id.profile);
        backArrowImageView = findViewById(R.id.backArrow);
        backArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_activity.this, Screen2.class);
                startActivity(intent);
                finish();


            }
        });



        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new firstFragment())
                        .addToBackStack(null).commit();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment=null;
                switch(tab.getPosition()){
                    case 0:
                        fragment= new firstFragment();
                        break;
                    case 1:
                        fragment= new secondFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}