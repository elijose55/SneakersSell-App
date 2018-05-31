package com.example.gabrielmoura.ace1;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firebase.ui.storage.images.FirebaseImageLoader;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<SneakerViewHolder> {

    private Context mContext;
    private List<SneakerCardData> mSneakerList;



    MyAdapter(Context mContext, List<SneakerCardData> mSneakerList) {
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

        //holder.mImage.setImageResource(mSneakerList.get(position).getSneakerImage());
        holder.mTitleNamee.setText(mSneakerList.get(position).getName());
        holder.mTitlePricee.setText("R$"+String.valueOf((mSneakerList.get(position).getPrice()))+",00");

        Glide.with(mContext)
                .using(new FirebaseImageLoader())
                .load(mSneakerList.get(position).getSneakerImage())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .fitCenter()
                .into(holder.mImagee);
        Log.d("tst","Adapter1");
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do something in response to card click

            }
        });
    }

    @Override
    public int getItemCount() {
        return mSneakerList.size();
    }
}

class SneakerViewHolder extends RecyclerView.ViewHolder {

    ImageView mImagee;
    TextView mTitleNamee;
    TextView mTitlePricee;
    CardView mCardView;

    SneakerViewHolder(View itemView) {

        super(itemView);

        mImagee = itemView.findViewById(R.id.ivImagee);
        mTitleNamee = itemView.findViewById(R.id.tvTitlee);
        mTitlePricee = itemView.findViewById(R.id.tvPricee);
        mCardView = itemView.findViewById(R.id.cardview);
        Log.d("tst","Adapter");

        }
    }
