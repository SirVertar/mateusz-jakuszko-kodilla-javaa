package com.kodilla.good.patterns.food2door;

import java.util.HashSet;
import java.util.Set;

class DeliveryShopsDatabase {
    private Set<DeliveryShop> usersSet = new HashSet<>();

    void addShop(DeliveryShop... deliveryShops) {
        for (DeliveryShop deliveryShop : deliveryShops) {
            int i = usersSet.size();
            usersSet.add(deliveryShop);
            if (i == usersSet.size()) {
                System.out.println("There is already such user in database: \n" + deliveryShop + "\n");
            }
        }
    }

    Set<DeliveryShop> getUsersSet() {
        return usersSet;
    }
}
