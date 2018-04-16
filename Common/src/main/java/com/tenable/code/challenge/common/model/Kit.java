package com.tenable.code.challenge.common.model;

public class Kit {
    private String description;
    private String id;
    private String name;
    private double basePrice;
    private String bodyKit;
    private String engine;
    private String fourWheels;
    private String color;
    private String finish;
    private boolean isDefaultParts;
    private Location location;

    public Kit(String description, String id, String name, double basePrice, String bodyKit, String engine, String fourWheels, String color, String finish, boolean isDefaultParts, Location location) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.bodyKit = bodyKit;
        this.engine = engine;
        this.fourWheels = fourWheels;
        this.color = color;
        this.finish = finish;
        this.isDefaultParts = isDefaultParts;
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
