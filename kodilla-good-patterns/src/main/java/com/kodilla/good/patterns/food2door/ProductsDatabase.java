package com.kodilla.good.patterns.food2door;

import java.util.HashSet;
import java.util.Set;

abstract class ProductsDatabase {
    Set<Product> productSet = new HashSet<>();

    void addProduct(Product... products) {
        for (Product product : products) {
            if (product != null && !productSet.contains(product)) {
                productSet.add(product);
            } else {
                System.out.println("There is already: \n" + product
                        + "\nin our database, u can only change it quantity or price\n");
            }
        }
    }

    Set<Product> getProductSet() {
        return productSet;
    }

}
