package com.kodilla.good.patterns.food2door;

public class User {

    private String name;
    private String surname;
    private int age;
    private Integer ID;
    private OrderRequest orderRequest;

    public User(String name, String surname, int age, Integer ID) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Integer getID() {
        return ID;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public void setOrderRequest(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }
}
