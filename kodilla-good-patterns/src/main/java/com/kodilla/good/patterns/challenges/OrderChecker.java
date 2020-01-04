package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.List;

interface OrderChecker {

    boolean order(User user, List<Product> listOfOrderedProducts, LocalDateTime orderedAt);
}
