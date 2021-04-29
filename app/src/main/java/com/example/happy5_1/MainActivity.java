package com.example.happy5_1;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.happy5_1.adapter.ViewAdapter;
import com.example.happy5_1.fragment.ClassFragment;
import com.example.happy5_1.fragment.GouFragment;
import com.example.happy5_1.fragment.HomeFragment;
import com.example.happy5_1.fragment.MineFragment;
import com.example.happy5_1.fragment.MsgFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private BottomNavigationView navigation;
    private List<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        list.add(new HomeFragment());
        list.add(new ClassFragment());
        list.add(new GouFragment());
        list.add(new MsgFragment());
        list.add(new MineFragment());

        ViewAdapter viewAdapter = new ViewAdapter(getSupportFragmentManager(),list);
        viewpager.setAdapter(viewAdapter);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigation.setSelectedItemId(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //超过三句 必加
        navigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.nav_shipin:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.nav_toutiao:
                        viewpager.setCurrentItem(2);
                        break;
                    case R.id.nav_msg:
                        viewpager.setCurrentItem(3);
                        break;
                    case R.id.nav_mine:
                        viewpager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });

    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
    }
}