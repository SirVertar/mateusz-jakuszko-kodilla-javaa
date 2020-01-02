package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.List;

interface OrderService {
    boolean order(User user, List<Product> listOfOrderedProducts, LocalDateTime orderedAt);
}
