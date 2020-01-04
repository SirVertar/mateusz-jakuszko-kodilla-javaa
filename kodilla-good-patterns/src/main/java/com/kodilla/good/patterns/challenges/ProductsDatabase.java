package com.kodilla.good.patterns.challenges;

import java.util.*;

class ProductsDatabase {

    private Map<Integer, Product> productsMap = new HashMap<>();

    void addProduct(Product product) {
        if (product != null && productsMap.get(product.getProductId()) == null) {
            productsMap.put(product.getProductId(), product);
        } else {
            System.out.println("There is already: \n" + product
                    + "\nin our database, u can only change it quantity or price\n");
        }
    }

    boolean checkAvailabilityOfProducts(List<Product> listOfProducts) {
        int quantityOfAvailableProducts = 0;
        for (Map.Entry<Integer, Product> entry : productsMap.entrySet()) {
            for (Product product : listOfProducts) {
                if (entry.getValue().equals(product)) {
                    quantityOfAvailableProducts++;
                }
            }
        }
        if (quantityOfAvailableProducts == listOfProducts.size()) {
            return true;
        }
        System.out.println("There is no such products in our shop (ProductsDatabase)");
        return false;
    }
}
