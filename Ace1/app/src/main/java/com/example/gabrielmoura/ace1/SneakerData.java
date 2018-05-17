package com.example.gabrielmoura.ace1;

public class SneakerData {

    private String sneakerName;
    private String sneakerDescription;
    private int sneakerImage;

    public SneakerData(String sneakerName, int sneakerImage) {
        this.sneakerName = sneakerName;
        this.sneakerImage = sneakerImage;
    }

    public String getSneakerName() {
        return sneakerName;
    }

    public int getSneakerImage() {
        return sneakerImage;
    }
}
