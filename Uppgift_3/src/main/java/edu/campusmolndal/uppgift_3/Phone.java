package edu.campusmolndal.uppgift_3;

public class Phone {
    private int id;
    private String name;
    private String brand;
    private int year;

    // Konstruktor, getters och setters
    public Phone(int id, String name, String brand, int year) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
