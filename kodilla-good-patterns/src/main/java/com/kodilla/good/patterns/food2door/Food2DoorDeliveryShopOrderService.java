package com.kodilla.good.patterns.food2door;

import java.util.List;
import java.util.Map;

class Food2DoorDeliveryShopOrderService {

    private Food2DoorOrderChecker orderChecker;
    private InformationService informationService;
    private Food2DoorProductsDatabase food2DoorProductsDatabase;
    private DeliveryShopsDatabase deliveryShopsDatabase;

    Food2DoorDeliveryShopOrderService(Food2DoorOrderChecker orderChecker, InformationService informationService, Food2DoorProductsDatabase food2DoorProductsDatabase, DeliveryShopsDatabase deliveryShopsDatabase) {
        this.orderChecker = orderChecker;
        this.informationService = informationService;
        this.food2DoorProductsDatabase = food2DoorProductsDatabase;
        this.deliveryShopsDatabase = deliveryShopsDatabase;
    }

    OrderDto order(OrderRequest orderRequest) {
        boolean isOrdered = orderChecker.order(orderRequest, food2DoorProductsDatabase, deliveryShopsDatabase);

        if (isOrdered) {
            for (Map.Entry<DeliveryShop, List<Product>> entry : orderChecker.getDeliveryShopListMap().entrySet()) {
                entry.getKey().getDeliveryShopOrderService().process(entry.getValue(), entry.getKey().getDeliveryShopInformationService());
            }
            informationService.sendConfirmationToUser(orderRequest.getUser());
            return new OrderDto(orderChecker.getDeliveryShopListMap(), orderRequest.getLocalDateTime());
        }
        return new OrderDto(orderChecker.getDeliveryShopListMap(), orderRequest.getLocalDateTime());
    }
}
