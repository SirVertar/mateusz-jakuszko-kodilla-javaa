package com.kodilla.good.patterns.challenges;

abstract class SportProduct extends Product {

    public SportProduct(String nameOfProduct, double price, Integer productId, Integer productQuantity) {
        super(nameOfProduct, price, productId, productQuantity);
    }
}
