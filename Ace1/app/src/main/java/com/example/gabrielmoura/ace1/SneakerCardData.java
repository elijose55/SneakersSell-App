package com.example.gabrielmoura.ace1;

import android.util.Log;

import com.google.firebase.storage.StorageReference;

public class SneakerCardData {

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void setUid(String uid) {
        this.uid = uid;
    }

    private String uid;

    public void setPrice(Long price) {
        this.price = price;
    }

    private Long price;
    private String sneakerImage;

    public SneakerCardData(){}

    public SneakerCardData(String uid, String name, Long price, String sneakerImage) {
        this.uid = uid;
        this.name = name;
        this.price = price;
        this.sneakerImage = sneakerImage;
    }


    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public Long getPrice() {
        return price;
    }

    public String getSneakerImage() {
        Log.d("tst","data");
        return sneakerImage;
    }
}
