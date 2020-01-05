package com.kodilla.good.patterns.food2door;

import java.util.HashSet;
import java.util.Set;

class UsersDatabase {

    private Set<User> usersSet = new HashSet<>();

    void addCustomer(User user) {
        int i = usersSet.size();
        usersSet.add(user);
        if (i == usersSet.size()) {
            System.out.println("There is already such user in database: \n" + user + "\n");
        }
    }

    boolean checkAvailabilityOfCustomer(User user) {
        if (usersSet.contains(user)) {
            return true;
        } else {
            System.out.println("There is no user in our database (UsersDatabase)");
            return false;
        }
    }
}
