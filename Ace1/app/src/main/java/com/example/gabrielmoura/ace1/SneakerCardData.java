package com.example.gabrielmoura.ace1;

public class SneakerCardData {

    private String sneakerName;
    private String sneakerDescription;
    private int sneakerImage;

    public SneakerCardData(String sneakerName, String sneakerDescription, int sneakerImage) {
        this.sneakerName = sneakerName;
        this.sneakerDescription = sneakerDescription;
        this.sneakerImage = sneakerImage;
    }

    public String getSneakerName() {
        return sneakerName;
    }

    public String getSneakerDescription() {
        return sneakerDescription;
    }

    public int getSneakerImage() {
        return sneakerImage;
    }
}
