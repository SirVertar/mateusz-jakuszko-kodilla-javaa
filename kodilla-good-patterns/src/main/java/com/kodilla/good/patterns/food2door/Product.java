package com.kodilla.good.patterns.food2door;

import java.util.Objects;

class Product {

    private String nameOfProduct;
    private double price;
    private Integer productId;
    private Integer productQuantity;
    private TypeOfProduct typeOfProduct;

    Product(String nameOfProduct, double price, Integer productId, Integer productQuantity, TypeOfProduct typeOfProduct) {
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.typeOfProduct = typeOfProduct;
    }

    private String getNameOfProduct() {
        return nameOfProduct;
    }

    private double getPrice() {
        return price;
    }

    private Integer getProductId() {
        return productId;
    }

    private Integer getProductQuantity() {
        return productQuantity;
    }

    private TypeOfProduct getTypeOfProduct() {
        return typeOfProduct;
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
                Objects.equals(getNameOfProduct(), product.getNameOfProduct()) &&
                Objects.equals(getProductId(), product.getProductId()) &&
                Objects.equals(getProductQuantity(), product.getProductQuantity()) &&
                Objects.equals(getTypeOfProduct(), product.getTypeOfProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfProduct(), getPrice(), getProductId(), getProductQuantity(), getTypeOfProduct());
    }
}
