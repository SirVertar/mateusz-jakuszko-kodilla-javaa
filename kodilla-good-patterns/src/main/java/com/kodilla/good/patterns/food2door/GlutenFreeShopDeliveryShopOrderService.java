package com.kodilla.good.patterns.food2door;

import java.util.List;

public class GlutenFreeShopDeliveryShopOrderService implements DeliveryShopOrderService {

    @Override
    public void process(List<Product> listOfProducts, DeliveryShopInformationService deliveryShopInformationService) {
        System.out.println("[Gluten Free Shop] - We don't need to check the products from listOfProducts because we trust Yours store database...:)");
        deliveryShopInformationService.sendMessageToShop();
    }
}
