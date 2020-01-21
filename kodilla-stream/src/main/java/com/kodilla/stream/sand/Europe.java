package com.kodilla.stream.sand;

import java.math.BigDecimal;
import com.kodilla.stream.sand.SandStorage;

public final class Europe implements SandStorage {
    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("12345678901234567890");
        return sandQuantity;
    }
}