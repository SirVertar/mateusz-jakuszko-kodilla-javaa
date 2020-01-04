package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Mateusz", "Jakuszko", 19,324, TypeOfUsers.NORMAL_USER);
        User user2 = new User("Weronika", "Jakuszko", 21,321, TypeOfUsers.PREMIUM_USER);

        Bicycle bicycle1 = new Bicycle("Cross 125", 3200, 1321, 5);
        Bicycle bicycle2 = new Bicycle("Cross 425", 3000, 13212, 1);
        ComputerMouse computerMouse1 = new ComputerMouse("Logitech G29", 420, 13423, 5);
        ComputerMouse computerMouse2 = new ComputerMouse("Logitech G50", 333, 134232, 2);
        ComputerMouse computerMouse3 = new ComputerMouse("Logitech G10", 333, 3213215, 2);
        HairDryer hairDryer1 = new HairDryer("Philips Dryer", 320, 123453, 320);
        HairDryer hairDryer2 = new HairDryer("Sony Dryer", 520, 12343453, 21);
        HairDryer hairDryer3 = new HairDryer("Sony Dryer", 520, 12343453, 21);

        ProductsDatabase productsDatabase = new ProductsDatabase();
        productsDatabase.addProduct(bicycle1);
        productsDatabase.addProduct(bicycle2);
        productsDatabase.addProduct(computerMouse1);
        productsDatabase.addProduct(computerMouse2);
        productsDatabase.addProduct(hairDryer1);
        productsDatabase.addProduct(hairDryer2);
        productsDatabase.addProduct(hairDryer3);

        NormalUsersDatabase normalUsersDatabase = new NormalUsersDatabase();
        normalUsersDatabase.addCustomer(user1);
        normalUsersDatabase.addCustomer(user2);

        List<Product> orderedList1 = new ArrayList<>();
        orderedList1.add(bicycle1);
        orderedList1.add(computerMouse2);
        orderedList1.add(hairDryer2);

        OrderRequest orderRequest = new OrderRequest(user1, orderedList1,
                LocalDateTime.of(1997, 8, 1, 12, 0));

        InformationService emailInformationService = new EmailInformationService();
        OrderChecker normalUserOrderChecker = new NormalUserOrderChecker();
        OrderRepository sqlOrderRepository = new SqlOrderRepository();

        ProductOrderService productOrderService = new ProductOrderService(normalUserOrderChecker, sqlOrderRepository,
                emailInformationService);

        productOrderService.process(orderRequest, productsDatabase, normalUsersDatabase);
    }
}
