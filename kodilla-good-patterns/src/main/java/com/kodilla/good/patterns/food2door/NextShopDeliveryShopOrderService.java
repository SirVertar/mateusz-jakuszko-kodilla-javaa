package com.kodilla.good.patterns.food2door;

import java.util.List;

public class NextShopDeliveryShopOrderService implements DeliveryShopOrderService {

    @Override
    public void process(List<Product> listOfProducts, DeliveryShopInformationService deliveryShopInformationService) {
        System.out.println("[Next Shop] - First we'll check the products from listOfProducts and after that:");
        deliveryShopInformationService.sendMessageToShop();
    }
}

