package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.List;

class OrderRequest {

    private User user;
    private List<Product> listOfOrderedProducts;
    private LocalDateTime orderedAt;


    OrderRequest(User user, List<Product> listOfOrderedProducts, LocalDateTime orderedAt) {
        this.user = user;
        this.listOfOrderedProducts = listOfOrderedProducts;
        this.orderedAt = orderedAt;
    }

    User getUser() {
        return user;
    }

    List<Product> getListOfOrderedProducts() {
        return listOfOrderedProducts;
    }

    LocalDateTime getOrderedAt() {
        return orderedAt;
    }
}
