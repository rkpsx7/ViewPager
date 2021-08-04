package com.example.viewpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.viewpager.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setAdapter();
    }

    private void setAdapter() {
        viewPagerAdapter pagerAdapter = new viewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        mBinding.viewPager.setAdapter(pagerAdapter);
        new TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText("Fragment - " + ++position);
            }
        }).attach();
    }
    public void setData(String name){
        this.name = name;
    }
    public String getData(){
        return name;
    }
}