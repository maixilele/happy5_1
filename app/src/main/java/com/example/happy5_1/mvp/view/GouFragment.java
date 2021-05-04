package com.example.happy5_1.mvp.view;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happy5_1.R;
import com.example.happy5_1.adapter.GouAdapter;
import com.example.happy5_1.entity.GouEntity;
import com.example.happy5_1.mvp.Contract.GouContract;
import com.example.happy5_1.mvp.model.GouModel;
import com.example.happy5_1.mvp.presenter.GouPresenter;
import com.example.lib_core.mvp.view.BaseFragment;

import java.util.ArrayList;
import java.util.List;


public class GouFragment extends BaseFragment<GouPresenter> implements GouContract.View {

    private RecyclerView gouRv;
    private CheckBox allCb;
    private TextView gouMoney;
    private Button gouBt;
    private GouAdapter gouAdapter;
    private List<GouEntity> list = new ArrayList<>();


    @Override
    public void initAdapter(ArrayList<GouEntity> gouEntity) {
        GouAdapter gouAdapter = new GouAdapter(gouEntity);
        gouRv.setAdapter(gouAdapter);
        gouRv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public int bandLayout() {
        return R.layout.fragment_gou;
    }

    @Override
    public void initView() {
        gouRv = findViewById(R.id.gou_rv);
        allCb = findViewById(R.id.all_cb);
        gouMoney = findViewById(R.id.gou_money);
        gouBt = findViewById(R.id.gou_bt);

    }

    @Override
    public void initData() {
        mPresenter = new GouPresenter(new GouModel(),this);
        mPresenter.getModel();

        allCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setSelected(allCb.isChecked());
                }
                mChanged();
                gouAdapter.notifyDataSetChanged();
            }
        });
    }

    private long n;
    private long price;
    private boolean flag;

    private void mChanged() {
        n = 0;
        price = 0;
        flag = true;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getSelected()) {
                flag = false;
            } else {
                n = list.get(i).getGoodsPrice() + n;
                price = list.get(i).getGoodsCount() * list.get(i).getGoodsPrice() + price;
            }
        }
        gouMoney.setText(price + "");
        gouBt.setText("结算" + "(" + n + ")");
    }
}