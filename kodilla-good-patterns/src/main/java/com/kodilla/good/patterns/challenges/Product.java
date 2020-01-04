package com.kodilla.good.patterns.challenges;

import java.util.Objects;

abstract class Product {

    private String nameOfProduct;
    private double price;
    private Integer productId;
    private Integer productQuantity;

    Product(String nameOfProduct, double price, Integer productId, Integer productQuantity) {
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    private String getNameOfProduct() {
        return nameOfProduct;
    }

    private double getPrice() {
        return price;
    }

    Integer getProductId() {
        return productId;
    }

    private Integer getProductQuantity() {
        return productQuantity;
    }

    @Override
    public String toString() {
        return "nameOfProduct: " + nameOfProduct + '\'' +
                ", price: " + price +
                ", productId: " + productId +
                ", productQuantity: " + productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getPrice(), getPrice()) == 0 &&
                getNameOfProduct().equals(product.getNameOfProduct()) &&
                getProductId().equals(product.getProductId()) &&
                getProductQuantity().equals(product.getProductQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfProduct(), getPrice(), getProductId(), getProductQuantity());
    }
}
