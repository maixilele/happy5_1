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
        // Required empty public constructor
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
        bannerbeans.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=259364631,2307942273&fm=26&gp=0.jpg");
        bannerbeans.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3765821666,4235344830&fm=26&gp=0.jpg");
        bannerbeans.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3336810809,2729597475&fm=26&gp=0.jpg");
        bannerbeans.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503471047&di=679d7a6c499f59d1b0dcd56b62a9aa6c&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.90sheji.com%2Fdianpu_cover%2F11%2F14%2F64%2F55%2F94ibannercsn_1200.jpg");
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