package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequest {
    private User user;
    private List<Product> productList;
    private LocalDateTime localDateTime;

    public OrderRequest(User user, List<Product> productList, LocalDateTime localDateTime) {
        this.user = user;
        this.productList = productList;
        this.localDateTime = localDateTime;
    }

    public User getUser() {
        return user;
    }

    List<Product> getProductList() {
        return productList;
    }

    LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
