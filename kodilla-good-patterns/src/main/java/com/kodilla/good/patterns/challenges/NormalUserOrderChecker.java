package com.kodilla.good.patterns.challenges;

public class NormalUserOrderChecker implements OrderChecker {

    @Override
    public boolean order(OrderRequest orderRequest, ProductsDatabase productsDatabase, UsersDatabase usersDatabase) {
        if (productsDatabase.checkAvailabilityOfProducts(orderRequest.getListOfOrderedProducts())
                && usersDatabase.checkAvailabilityOfCustomer(orderRequest.getUser())
                && orderRequest.getUser().getTypeOfUsers() == TypeOfUsers.NORMAL_USER) {
            return true;
        }
        System.out.println("There are one of the problems below:\n"
                + "There are no such products in our shop or\n"
                + "There is no such user in our database or\n"
                + "You aren't a Normal user.\n");
        return false;
    }
}
