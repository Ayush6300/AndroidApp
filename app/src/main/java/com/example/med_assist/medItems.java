package com.example.med_assist;

public class medItems {
    private String imageRes;
    private String id;
    private String name;
    private String description;
    private String mrp;
    private String finalPrice;
    private String discount;

    public medItems(String imageRes, String name, String description, String mrp , String finalPrice, String discount, String id) {
        this.imageRes = imageRes;
        this.id = id;
        this.name = name;
        this.description = description;
        this.mrp = mrp;
        this.finalPrice = finalPrice;
        this.discount = discount;
    }

    public String getMrp() {
        return mrp;
    }


    public String getFinalPrice() {
        return finalPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public String getImageRes() {
        return imageRes;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

}
