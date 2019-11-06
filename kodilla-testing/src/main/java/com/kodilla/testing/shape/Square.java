package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {

    private double sideOfSquare;

    public Square() {
    }

    public Square(double sideOfSquare) {
        this.sideOfSquare = sideOfSquare;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return sideOfSquare * sideOfSquare;
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

    @Override
    public String toString() {
        return "Square";
    }

}
