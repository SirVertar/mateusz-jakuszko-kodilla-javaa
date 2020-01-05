package com.kodilla.good.patterns.food2door;

import java.util.*;

public class DeliveryShop {
    private String name;
    private String address;
    private DeliveryShopOrderService deliveryShopOrderService;
    private Integer producerId;
    private ProductsDatabase productsDatabase;
    private DeliveryShopInformationService deliveryShopInformationService;


    DeliveryShop(String name, String address, DeliveryShopOrderService deliveryShopOrderService,
                 Integer producerId, ProductsDatabase productsDatabase,
                 DeliveryShopInformationService deliveryShopInformationService) {
        this.name = name;
        this.address = address;
        this.deliveryShopOrderService = deliveryShopOrderService;
        this.producerId = producerId;
        this.productsDatabase = productsDatabase;
        this.deliveryShopInformationService = deliveryShopInformationService;
    }

    private String getName() {
        return name;
    }

    private String getAddress() {
        return address;
    }

    DeliveryShopOrderService getDeliveryShopOrderService() {
        return deliveryShopOrderService;
    }

    private Integer getProducerId() {
        return producerId;
    }

    ProductsDatabase getProductsDatabase() {
        return productsDatabase;
    }

    DeliveryShopInformationService getDeliveryShopInformationService() {
        return deliveryShopInformationService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeliveryShop)) return false;
        DeliveryShop that = (DeliveryShop) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getDeliveryShopOrderService(), that.getDeliveryShopOrderService()) &&
                Objects.equals(getProducerId(), that.getProducerId()) &&
                Objects.equals(getProductsDatabase(), that.getProductsDatabase()) &&
                Objects.equals(deliveryShopInformationService, that.deliveryShopInformationService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), getDeliveryShopOrderService(), getProducerId(), getProductsDatabase(), deliveryShopInformationService);
    }
}
