package com.example.chap_7;

public class Drinks {
    private String name;
    private String description;
    private int imageResourceId;
    //drinks is an array of Drinks
    public static final Drinks[] drink = {
            new Drinks("Latte", "A couple of espresso shots with steamed milk",
                    R.drawable.latte),
            new Drinks("Cappuccino", "Espresso, hot milk, and a steamed milk foam",
                    R.drawable.cappuccino),
            new Drinks("Filter", "Highest quality beans roasted and brewed fresh",
                    R.drawable.filter)
    };
    //Each Drink has a name, description, and an image resource
    private Drinks(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public String toString(){return this.name;}
}

