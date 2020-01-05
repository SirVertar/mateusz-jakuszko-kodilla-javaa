package com.kodilla.good.patterns.food2door;

public interface OrderChecker {

    boolean order(OrderRequest orderRequest, ProductsDatabase productsDatabase, DeliveryShopsDatabase deliveryShopsDatabase);
}
