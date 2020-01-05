package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("Mateusz", "Jakuszko", 21, 32);
        UsersDatabase usersDatabase = new UsersDatabase();
        usersDatabase.addCustomer(user);

        Product goudaGalbani = new Product("Gouda Premium", 32, 431239, 2, Cheeses.GOUDA);
        Product goudaLidl = new Product("Gouda Premium", 25, 531239, 2, Cheeses.GOUDA);
        Product goudaPremium = new Product("Gouda Premium", 28, 631239, 2, Cheeses.GOUDA);
        Product fetaGalbani = new Product("Gouda Premium", 25, 731239, 2, Cheeses.FETA);
        Product fetaBiedronka = new Product("Gouda Premium", 20, 831239, 2, Cheeses.FETA);
        Product fetaLidl = new Product("Gouda Premium", 37, 931239, 2, Cheeses.FETA);
        Product granaPadanoGalbani = new Product("Gouda Premium", 36, 131239, 2, Cheeses.GRANA_PADANO);
        Product granaPadanoLidl = new Product("Gouda Premium", 35, 231239, 2, Cheeses.GRANA_PADANO);

        Product appleLidl = new Product("Apple Lidl", 4, 32211, 21, Fruits.APPLE);
        Product appleBiedronka = new Product("Apple Biedronka", 4, 321321, 25, Fruits.APPLE);
        Product pearLidl = new Product("Pear Lidl", 4, 31211, 150, Fruits.PEAR);
        Product pearBiedronka = new Product("Pear Biedronka", 4, 32811, 11, Fruits.PEAR);
        Product grapeLidl = new Product("Grape Lidl", 4, 35211, 30, Fruits.GRAPE);
        Product grapeBiedronka = new Product("Grape Biedronka", 4, 32711, 11, Fruits.GRAPE);
        Product orangeLidl = new Product("Orange Lidl", 4, 36211, 20, Fruits.ORANGE);
        Product orangeBiedronka = new Product("Orange Biedronka", 4, 32191, 630, Fruits.ORANGE);
        Product bananaLidl = new Product("Banana Lidl", 4, 32121, 520, Fruits.BANANA);
        Product bananaBiedronka = new Product("Banana Biedronka", 4, 32113, 120, Fruits.BANANA);

        Product carrotLidl = new Product("Carrot Lidl", 4, 32211, 21, Vegetables.CARROT);
        Product carrotBiedronka = new Product("Carrot Biedronka", 4, 321321, 25, Vegetables.CARROT);
        Product asparagusLidl = new Product("Asparagus Lidl", 4, 31211, 150, Vegetables.ASPARAGUS);
        Product asparagusBiedronka = new Product("Asparagus Biedronka", 4, 32811, 11, Vegetables.ASPARAGUS);
        Product aubergineLidl = new Product("Aubergine Lidl", 4, 35211, 30, Vegetables.AUBERGINE);
        Product aubergineBiedronka = new Product("Aubergine Biedronka", 4, 32711, 11, Vegetables.AUBERGINE);
        Product cucumberLidl = new Product("Cucumber Lidl", 4, 36211, 20, Vegetables.CUCUMBER);
        Product cucumberBiedronka = new Product("Cucumber Biedronka", 4, 32191, 630, Vegetables.CUCUMBER);
        Product parsleyLidl = new Product("Parsley Lidl", 4, 32121, 520, Vegetables.PARSLEY);
        Product parsleyBiedronka = new Product("Parsley Biedronka", 4, 32113, 120, Vegetables.PARSLEY);

        ExtraFoodShopDeliveryShopOrderService extraFoodShopOrderService = new ExtraFoodShopDeliveryShopOrderService();
        ProductsDatabase extraFoodShopProductsDatabase = new DeliveryStoreProductsDatabase();
        extraFoodShopProductsDatabase.addProduct(appleLidl, carrotBiedronka, goudaGalbani, parsleyBiedronka);

        GlutenFreeShopDeliveryShopOrderService glutenFreeShopOrderService = new GlutenFreeShopDeliveryShopOrderService();
        ProductsDatabase glutenFreeShopProductsDatabase = new DeliveryStoreProductsDatabase();
        glutenFreeShopProductsDatabase.addProduct(appleBiedronka, aubergineBiedronka, cucumberBiedronka, parsleyLidl);

        NextShopDeliveryShopOrderService nextShopOrderService = new NextShopDeliveryShopOrderService();
        ProductsDatabase nextShopProductsDatabase = new DeliveryStoreProductsDatabase();
        nextShopProductsDatabase.addProduct(orangeLidl, goudaLidl, orangeBiedronka);

        Food2DoorProductsDatabase food2DoorProductsDatabase = new Food2DoorProductsDatabase();
        food2DoorProductsDatabase.addProductSet(extraFoodShopProductsDatabase.getProductSet());
        food2DoorProductsDatabase.addProductSet(glutenFreeShopProductsDatabase.getProductSet());
        food2DoorProductsDatabase.addProductSet(nextShopProductsDatabase.getProductSet());

        EmailDeliveryShopInformationService extraFoodShopInformationService = new EmailDeliveryShopInformationService();
        SmsDeliveryShopInformationService glutenFreeShopInformationService = new SmsDeliveryShopInformationService();
        EmailDeliveryShopInformationService nextShopFoodShopInformationService = new EmailDeliveryShopInformationService();

        DeliveryShop extraFoodShop = new DeliveryShop("ExtraFoodShop", "ul. Kraszewskiego 26A Poznań",
                extraFoodShopOrderService, 1, extraFoodShopProductsDatabase, extraFoodShopInformationService);
        DeliveryShop glutenFreeShop = new DeliveryShop("GlutenFreeShop", "ul. Sienkiewicza 26A Terespol",
                glutenFreeShopOrderService, 2, glutenFreeShopProductsDatabase, glutenFreeShopInformationService);
        DeliveryShop nextShop = new DeliveryShop("NextShop", "ul. Milczańska 23 Warszawa",
                nextShopOrderService, 3, nextShopProductsDatabase, nextShopFoodShopInformationService);

        DeliveryShopsDatabase food2DoorDeliveryShopsDatabase = new DeliveryShopsDatabase();
        food2DoorDeliveryShopsDatabase.addShop(extraFoodShop, glutenFreeShop, nextShop);

        List<Product> orderList = new ArrayList<>();
        orderList.add(appleLidl);
        orderList.add(carrotBiedronka);
        orderList.add(goudaGalbani);
        orderList.add(parsleyBiedronka);

        orderList.add(appleBiedronka);
        orderList.add(aubergineBiedronka);
        orderList.add(cucumberBiedronka);
        orderList.add(parsleyLidl);

        orderList.add(orangeLidl);
        orderList.add(goudaLidl);
        orderList.add(orangeBiedronka);

        LocalDateTime localDateTime = LocalDateTime.of(2020, 1, 5, 12, 30, 0);

        OrderRequest orderRequest = new OrderRequest(user, orderList, localDateTime);

        user.setOrderRequest(orderRequest);

        Food2DoorOrderChecker food2DoorOrderChecker = new Food2DoorOrderChecker();

        Food2DoorInformationService food2DoorInformationService = new Food2DoorInformationService();

        DeliveryShopsDatabase deliveryShopsDatabase = new DeliveryShopsDatabase();
        deliveryShopsDatabase.addShop(extraFoodShop, glutenFreeShop, nextShop);

        Food2DoorDeliveryShopOrderService food2DoorDeliveryShopOrderService
                = new Food2DoorDeliveryShopOrderService(food2DoorOrderChecker, food2DoorInformationService,
                food2DoorProductsDatabase, deliveryShopsDatabase);
        food2DoorDeliveryShopOrderService.order(orderRequest);
    }
}
