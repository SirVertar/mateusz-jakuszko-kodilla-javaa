package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {

    private double sideOfTriangle;
    private double heightOfTriangle;

    public Triangle(double sideOfTriangle, double heightOfTriangle) {
        this.sideOfTriangle = sideOfTriangle;
        this.heightOfTriangle = heightOfTriangle;
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
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.sideOfTriangle, sideOfTriangle) == 0 &&
                Double.compare(triangle.heightOfTriangle, heightOfTriangle) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideOfTriangle, heightOfTriangle);
    }
}
