package com.kodilla.good.patterns.challenges;

class NormalUsersDatabase extends UsersDatabase {
    @Override
    void addCustomer(User user) {
        if (user.getTypeOfUsers() == TypeOfUsers.NORMAL_USER) {
            super.addCustomer(user);
            return;
        }
        System.out.println("This is not a Normal User. There is no possibility to add him to NormalUsersDatabase");
    }
}
