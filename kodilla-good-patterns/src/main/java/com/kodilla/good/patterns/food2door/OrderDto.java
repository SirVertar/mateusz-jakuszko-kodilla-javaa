package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDto {

    private Map<DeliveryShop, List<Product>> deliveryShopListMap = new HashMap<>();
    private LocalDateTime localDateTime;

    OrderDto(Map<DeliveryShop, List<Product>> deliveryShopListMap, LocalDateTime localDateTime) {
        this.deliveryShopListMap = deliveryShopListMap;
        this.localDateTime = localDateTime;
    }

    public Map<DeliveryShop, List<Product>> getDeliveryShopListMap() {
        return deliveryShopListMap;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
