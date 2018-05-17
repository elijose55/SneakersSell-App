package com.example.gabrielmoura.ace1;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<SneakerViewHolder> {

    private Context mContext;
    private List<SneakerData> mSneakerList;

    MyAdapter(Context mContext, List<SneakerData> mSneakerList) {
        this.mContext = mContext;
        this.mSneakerList = mSneakerList;
    }

    @Override
    public SneakerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item, parent, false);
        return new SneakerViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final SneakerViewHolder holder, int position) {
        holder.mImage.setImageResource(mSneakerList.get(position).getSneakerImage());
        holder.mTitle.setText(mSneakerList.get(position).getSneakerName());
    }

    @Override
    public int getItemCount() {
        return mSneakerList.size();
    }
}

class SneakerViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mTitle;
    CardView mCardView;

    SneakerViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mCardView = itemView.findViewById(R.id.cardview);
    }
}