package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.List;

interface OrderChecker {

    boolean order(OrderRequest orderRequest, ProductsDatabase productsDatabase, UsersDatabase usersDatabase);
}
