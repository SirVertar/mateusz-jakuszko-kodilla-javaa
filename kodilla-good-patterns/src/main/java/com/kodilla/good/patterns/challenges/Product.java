package com.kodilla.good.patterns.challenges;

abstract class Product {

    private double price;
    private String nameOfProduct;

    public Product(double price, String nameOfProduct) {
        this.price = price;
        this.nameOfProduct = nameOfProduct;
    }

    double getPrice() {
        return price;
    }

    String getNameOfProduct() {
        return nameOfProduct;
    }
}
