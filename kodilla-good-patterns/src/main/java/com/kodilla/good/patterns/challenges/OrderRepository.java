package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository {

    void order(User user, List<Product> listOfOrderedProducts, LocalDateTime orderedAt);
}
