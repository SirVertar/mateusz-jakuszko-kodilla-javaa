package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {

    private double sideOfSquare;

    public Square(double sideOfSquare) {
        this.sideOfSquare = sideOfSquare;
    }

    @Override
    public String getShapeName() {
        return null;
    }

    @Override
    public double getField() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.sideOfSquare, sideOfSquare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideOfSquare);
    }
}
