package com.example.ahmed150236.touestguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     try {
         ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
         TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);

         cuntryFragmentAdapter mcuntryFragmentAdapter=new cuntryFragmentAdapter(this,getSupportFragmentManager());
         viewPager.setAdapter(mcuntryFragmentAdapter);
         tabLayout.setupWithViewPager(viewPager);
     }catch (Exception e){
         Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
     }

    }
}
