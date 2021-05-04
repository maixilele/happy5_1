package com.example.happy5_1.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.happy5_1.R;
import com.example.happy5_1.fragment.home.bean.BannerBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private Banner bannerHome;
    private ViewFlipper viewFlipperHome;
    private RecyclerView homeRecycler;
    View inflate;
    private List<String> bannerbeans=new ArrayList<>();

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflate= inflater.inflate(R.layout.fragment_home, container, false);
        initview();
        initbanner();
        initnews();
        return inflate;
    }

    //加载公告
    private void initnews() {
        viewFlipperHome.startFlipping();
    }

    //加载banner
    private void initbanner() {
        BannerBean bannerBean = new BannerBean();

        bannerbeans.add(bannerBean.HOME_BANNER_ONE);
        bannerbeans.add(bannerBean.HOME_BANNER_TWO);
        bannerbeans.add(bannerBean.HOME_BANNER_THREE);
        bannerbeans.add(bannerBean.HOME_BANNER_FOUR);

        bannerHome.setImages(bannerbeans);
        bannerHome.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                String pic = (String) path;
                Log.e("123", "displayImage: "+pic );
                Glide.with(context).load(pic).into(imageView);
            }
        });
        bannerHome.setDelayTime(2000);
        bannerHome.setIndicatorGravity(BannerConfig.RIGHT);
        bannerHome.start();
    }

    private void initview() {
        bannerHome = (Banner)inflate.findViewById(R.id.banner_home);
        viewFlipperHome = (ViewFlipper)inflate.findViewById(R.id.viewFlipper_home);
        homeRecycler = (RecyclerView)inflate.findViewById(R.id.home_recycler);
    }
}