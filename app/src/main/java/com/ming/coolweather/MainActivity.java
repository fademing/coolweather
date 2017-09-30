package com.ming.coolweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ming.coolweather.util.MainViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private MainViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton rb_weather,rb_view,rb_setting;
    private List<Fragment> fragmentList;
    private MainPageAdapter mainPageAdapter;
    private Button nav_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
        initView();
        initData ();

//        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
//        if (pref.getString("weather",null) !=null){
//            Intent intent = new Intent(this,WeatherFragment.class);
//            startActivity(intent);
//            finish();
//        }
    }

    private void initData() {

        mainPageAdapter = new MainPageAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setOffscreenPageLimit (fragmentList.size () - 1);
        viewPager.setAdapter (mainPageAdapter);


    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout);
        viewPager = (MainViewPager) findViewById(R.id.view_pager);
        viewPager.setNoScroll(true);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        rb_weather = (RadioButton) findViewById(R.id.rb_weather);
        rb_view = (RadioButton) findViewById(R.id.rb_view);
        rb_setting = (RadioButton) findViewById(R.id.rb_setting);
        nav_btn = (Button) findViewById(R.id.nav_btn);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                nav_btn.setVisibility(View.GONE);
                switch (checkedId){
                    case R.id.rb_weather:
                        nav_btn.setVisibility(View.VISIBLE);
                        viewPager.setCurrentItem(0,false);
                        break;
                    case R.id.rb_view:
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.rb_setting:
                        viewPager.setCurrentItem(2,false);
                        break;
                }
            }
        });
        radioGroup.check(0);
        nav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_MOVE:
//                        viewPager.requestDisallowInterceptTouchEvent(true);
//                        break;
//                    case MotionEvent.ACTION_CANCEL:
//                        viewPager.requestDisallowInterceptTouchEvent(false);
//                    default:
//                        break;
//                }
//                return true;
//            }
//        });
    }

    private void initFragment() {

        fragmentList = new ArrayList<>();
        WeatherFragment weatherFragment = new WeatherFragment();
        fragmentList.add(weatherFragment);
        ViewFragment viewFragment = new ViewFragment();
        fragmentList.add(viewFragment);
        SettingFragment settingFragment = new SettingFragment();
        fragmentList.add(settingFragment);
    }
}
