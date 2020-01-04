package com.kodilla.good.patterns.challenges;

import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private int age;
    private Integer userId;
    private TypeOfUsers typeOfUsers;


    User(String name, String surname, int age, int userId, TypeOfUsers typeOfUsers) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.userId = userId;
        this.typeOfUsers = typeOfUsers;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    TypeOfUsers getTypeOfUsers() {
        return typeOfUsers;
    }

    private int getAge() {
        return age;
    }

    private int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "name: " + name + '\'' +
                ", surname: " + surname + '\'' +
                ", age: " + age +
                ", userId: " + userId +
                ", typeOfUsers: " + typeOfUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                getUserId() == user.getUserId() &&
                getName().equals(user.getName()) &&
                getSurname().equals(user.getSurname()) &&
                getTypeOfUsers() == user.getTypeOfUsers();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getUserId(), getTypeOfUsers());
    }
}
