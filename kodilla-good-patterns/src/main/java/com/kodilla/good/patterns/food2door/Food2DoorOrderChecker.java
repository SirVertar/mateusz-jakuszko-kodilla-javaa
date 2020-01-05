package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Food2DoorOrderChecker implements OrderChecker {

    private Map<DeliveryShop, List<Product>> deliveryShopListMap;

    @Override
    public boolean order(OrderRequest orderRequest, ProductsDatabase productsDatabase, DeliveryShopsDatabase deliveryShopsDatabase) {
        deliveryShopListMap = new HashMap<>();
        List<Product> orderListOfProducts = orderRequest.getProductList();
        for (DeliveryShop deliveryShop : deliveryShopsDatabase.getUsersSet()) {
            deliveryShopListMap.put(deliveryShop, new ArrayList<>());
            for (Product product : orderListOfProducts) {
                if (deliveryShop.getProductsDatabase().getProductSet().contains(product)) {
                    deliveryShopListMap.get(deliveryShop).add(product);
                }
            }
            removeProductsFromMap(deliveryShopListMap, orderListOfProducts);
        }
        if (orderListOfProducts.size() != 0) {
            System.out.println("There is " + orderListOfProducts.size() + " which we haven't... Sorry");
            return false;
        }
        System.out.println("All products are available");
        return true;
    }

    private void removeProductsFromMap(Map<DeliveryShop, List<Product>> orderMap, List<Product> orderListOfProducts) {
        for (Map.Entry<DeliveryShop, List<Product>> entry : orderMap.entrySet()) {
            for (Product product : entry.getValue()) {
                orderListOfProducts.remove(product);
            }
        }
    }

    Map<DeliveryShop, List<Product>> getDeliveryShopListMap() {
        return deliveryShopListMap;
    }
}
