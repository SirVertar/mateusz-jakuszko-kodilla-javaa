package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Autowired
    private final Display display = new Display();

    double add(double a, double b) {
        display.displayValue(a + b);
        return a + b;
    }

    double sub(double a, double b) {
        display.displayValue(a - b);
        return a - b;
    }

    double mul(double a, double b) {
        display.displayValue(a * b);
        return a * b;
    }

    double div(double a, double b) {
        display.displayValue(a / b);
        return a / b;
    }


}
