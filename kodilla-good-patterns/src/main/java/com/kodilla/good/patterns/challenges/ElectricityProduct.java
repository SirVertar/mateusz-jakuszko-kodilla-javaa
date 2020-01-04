package com.kodilla.good.patterns.challenges;

abstract class ElectricityProduct extends Product {

    public ElectricityProduct(String nameOfProduct, double price, Integer productId, Integer productQuantity) {
        super(nameOfProduct, price, productId, productQuantity);
    }
}
