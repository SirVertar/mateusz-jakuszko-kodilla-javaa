package com.kodilla.good.patterns.food2door;

import java.util.List;

public class ExtraFoodShopDeliveryShopOrderService implements DeliveryShopOrderService {

    @Override
    public void process(List<Product> listOfProducts, DeliveryShopInformationService deliveryShopInformationService) {
        System.out.println("[Extra Food Shop] - First we'll check the products from listOfProducts and after that:");
        deliveryShopInformationService.sendMessageToShop();
    }
}
