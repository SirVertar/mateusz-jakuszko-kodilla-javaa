package com.kodilla.good.patterns.food2door;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class Producer {
    private String name;
    private String address;
    private OrderService orderService;
    private List<Vegetables> listOfVegetables = new LinkedList<>();
    private List<Fruits> listOfFruits = new LinkedList<>();


    Producer(String name, String address, OrderService orderService) {
        this.name = name;
        this.address = address;
        this.orderService = orderService;
    }

    void addVegetables (Vegetables... vegetables) {
        listOfVegetables.addAll(Arrays.asList(vegetables));
    }

    void addFruits (Fruits... fruits) {
        listOfFruits.addAll(Arrays.asList(fruits));
    }


    private String getName() {
        return name;
    }

    private String getAddress() {
        return address;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producer)) return false;
        Producer producer = (Producer) o;
        return getName().equals(producer.getName()) &&
                getAddress().equals(producer.getAddress()) &&
                listOfVegetables.equals(producer.listOfVegetables) &&
                listOfFruits.equals(producer.listOfFruits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), listOfVegetables, listOfFruits);
    }
}
