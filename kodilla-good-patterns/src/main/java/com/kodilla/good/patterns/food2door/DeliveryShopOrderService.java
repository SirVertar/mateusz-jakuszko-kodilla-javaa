package com.kodilla.good.patterns.food2door;

import java.util.List;

public interface DeliveryShopOrderService {

    void process(List<Product> listOfProducts, DeliveryShopInformationService deliveryShopInformationService);
}
