package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.List;

public class NormalCustomerOrderService implements OrderService {

    @Override
    public boolean order(User user, List<Product> listOfOrderedProducts, LocalDateTime orderedAt) {
        return user != null && listOfOrderedProducts != null && orderedAt != null;
    }
}
