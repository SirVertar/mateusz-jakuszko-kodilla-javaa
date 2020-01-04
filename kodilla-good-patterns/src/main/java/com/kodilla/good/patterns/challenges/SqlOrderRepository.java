package com.kodilla.good.patterns.challenges;

public class SqlOrderRepository implements OrderRepository {

    @Override
    public void saveOrderIntoRepository(OrderRequest orderRequest) {
        System.out.println("Success!!! The order has saved into SQL repository");
    }
}
