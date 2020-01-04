package com.kodilla.good.patterns.challenges;

import java.util.*;

public class OrderDto {

    private User user;
    private List<Product> listOfOrderedProducts;
    private boolean isOrdered;

    OrderDto(User user, List<Product> listOfOrderedProducts, boolean isOrdered) {
        this.user = user;
        this.listOfOrderedProducts = listOfOrderedProducts;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getListOfOrderedProducts() {
        return listOfOrderedProducts;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
