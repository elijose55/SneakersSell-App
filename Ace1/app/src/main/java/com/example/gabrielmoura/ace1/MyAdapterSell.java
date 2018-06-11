package com.example.gabrielmoura.ace1;


import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;



public class MyAdapterSell extends RecyclerView.Adapter<SneakerViewHolderSell> {


    ViewPager viewPager;
    private Context mContext;
    private List<SneakerCardData> mSneakerList;
    private StorageReference tenis_ref;


    MyAdapterSell(Context mContext, List<SneakerCardData> mSneakerList) {
        this.mContext = mContext;
        this.mSneakerList = mSneakerList;
    }


    @Override
    public SneakerViewHolderSell onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_sell, parent, false);

        return new SneakerViewHolderSell(mView);
    }
    private void openNextActivity(int position) {
        Intent intent = new Intent(mContext, Buy2Activity.class);
        intent.putExtra("IMAGE_REFERENCE",mSneakerList.get(position).getSneakerImage());
        intent.putExtra("NAME_REFERENCE",mSneakerList.get(position).getName());
        intent.putExtra("PRICE_REFERENCE",mSneakerList.get(position).getPrice());
        mContext.startActivity(intent);


    }
    @Override
    public void onBindViewHolder(final SneakerViewHolderSell holder, final int position) {

        //holder.mImage.setImageResource(mSneakerList.get(position).getSneakerImage());
        holder.mTitleNamee.setText("Opção de venda");
        holder.mTitlePricee.setText("R$"+String.valueOf((mSneakerList.get(position).getPrice()))+",00");
        //referencia para o storage
        FirebaseStorage storage = FirebaseStorage.getInstance();

        final StorageReference storageRef = storage.getReference("images");
        tenis_ref = storageRef.child(mSneakerList.get(position).getSneakerImage());

        Glide.with(mContext)
                .using(new FirebaseImageLoader())
                .load(tenis_ref)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .thumbnail(Glide.with(mContext).load(R.drawable.loading))
                .dontAnimate()
                .fitCenter()
                .into(holder.mImagee);
        Log.d("tst","Adapter1");
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do something in response to card click
                openNextActivity(position);
            }


        });
    }

    @Override
    public int getItemCount() {
        return mSneakerList.size();
    }
}

class SneakerViewHolderSell extends RecyclerView.ViewHolder {

    ImageView mImagee;
    TextView mTitleNamee;
    TextView mTitlePricee;
    CardView mCardView;

    SneakerViewHolderSell(View itemView) {

        super(itemView);

        mImagee = itemView.findViewById(R.id.ivImagee);
        mTitleNamee = itemView.findViewById(R.id.tvTitlee);
        mTitlePricee = itemView.findViewById(R.id.tvPricee);
        mCardView = itemView.findViewById(R.id.cardview);
        Log.d("tst","Adapter");

    }

}

