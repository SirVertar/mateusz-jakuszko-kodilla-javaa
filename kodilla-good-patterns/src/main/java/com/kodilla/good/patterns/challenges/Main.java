package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user = new User("Mateusz", "Jakuszko", 19);
        Bicycle bicycle = new Bicycle(3245, "Cross 125");
        ComputerMouse computerMouse = new ComputerMouse(320, "Logitech G29");
        HairDryer hairDryer = new HairDryer(350, "Philips Dryer");

        List<Product> orderedList = new ArrayList<>();
        orderedList.add(bicycle);
        orderedList.add(computerMouse);
        orderedList.add(hairDryer);

        OrderRequest orderRequest = new OrderRequest(user, orderedList,
                LocalDateTime.of(1997, 8, 1, 12, 0));
        EmailInformationService emailInformationService = new EmailInformationService();
        NormalCustomerOrderChecker normalCustomerOrderChecker = new NormalCustomerOrderChecker();
        SqlOrderRepository sqlOrderRepository = new SqlOrderRepository();

        ProductOrderService productOrderService = new ProductOrderService(normalCustomerOrderChecker, sqlOrderRepository,
                emailInformationService);

        productOrderService.process(orderRequest);

    }
}
