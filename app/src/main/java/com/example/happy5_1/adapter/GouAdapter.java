package com.example.happy5_1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happy5_1.R;
import com.example.happy5_1.entity.GouEntity;

import java.util.ArrayList;

public class GouAdapter extends RecyclerView.Adapter<GouAdapter.MyHolder> {

    private ArrayList<GouEntity> gouEntity;

    public GouAdapter(ArrayList<GouEntity> gouEntity) {
        this.gouEntity = gouEntity;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gou, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.textView.setText(gouEntity.get(position).getGoodsDesc());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.gou_tv);
        }
    }
}
