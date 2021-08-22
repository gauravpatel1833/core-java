package com.corejava.practice.corejava.comparatorvscomparable;

public class LaptopBean implements Comparable<LaptopBean> {

    private String brand;
    private int ram;
    private int price;

    public LaptopBean(String brand, int ram, int price) {
        super();
        this.brand = brand;
        this.ram = ram;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LaptopBean{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(LaptopBean o) {
        return this.getBrand().compareTo(o.getBrand());
    }
}
