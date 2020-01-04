package com.kodilla.good.patterns.challenges;

class ProductOrderService {

    private OrderChecker orderChecker;
    private OrderRepository orderRepository;
    private InformationService informationService;

    ProductOrderService(OrderChecker orderChecker, OrderRepository orderRepository, InformationService informationService) {
        this.orderChecker = orderChecker;
        this.orderRepository = orderRepository;
        this.informationService = informationService;
    }

    OrderDto process(final OrderRequest orderRequest, final ProductsDatabase productsDatabase, final UsersDatabase usersDatabase) {
        boolean isOrdered = orderChecker.order(orderRequest, productsDatabase, usersDatabase);
        if (isOrdered) {
            informationService.sendConfirmationToUser(orderRequest.getUser());
            orderRepository.saveOrderIntoRepository(orderRequest);
            System.out.println("Your order is accepted!!");
            return new OrderDto(orderRequest.getUser(), orderRequest.getListOfOrderedProducts(), true);
        }
        System.out.println("Your order isn't accepted!!");
        return new OrderDto(orderRequest.getUser(), orderRequest.getListOfOrderedProducts(), false);

    }

}
