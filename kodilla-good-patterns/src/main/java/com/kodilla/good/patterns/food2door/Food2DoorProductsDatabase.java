package com.kodilla.good.patterns.food2door;

import java.util.Set;

class Food2DoorProductsDatabase extends ProductsDatabase {

    void addProductSet(Set<Product> productSet) {
        if (productSet.size() > 0 && !this.productSet.contains(productSet)) {
            this.productSet.addAll(productSet);
        } else {
            System.out.println("There is already this products \n"
                    + "\nin our database, u can only change it quantity or price\n");
        }
    }
}
