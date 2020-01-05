package com.kodilla.good.patterns.food2door;

public class EmailDeliveryShopInformationService implements DeliveryShopInformationService {

    @Override
    public void sendMessageToShop() {
        System.out.println("We'll send and email with confirmation...");
    }
}
