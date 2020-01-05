package com.kodilla.good.patterns.food2door;

public class SmsDeliveryShopInformationService implements DeliveryShopInformationService {

    @Override
    public void sendMessageToShop() {
        System.out.println("We are sending sms...");
    }
}
