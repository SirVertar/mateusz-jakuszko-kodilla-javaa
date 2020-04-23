package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> listOfShapes = new ArrayList<Shape>();

    public boolean addFigure(Shape shape) {
        if (shape != null) {
            listOfShapes.add(shape);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeFigure(Shape shape) {
        if (listOfShapes.indexOf(shape) >= 0) {
            listOfShapes.remove(shape);
            return true;
        } else {
            return false;
        }
    }

    public Shape getFigure(int n) {
        return listOfShapes.get(n);
    }

    public String showFigures() {
        StringBuilder allFigures = new StringBuilder();
        for (int i = 0; i < listOfShapes.size(); i++) {
            if (i < listOfShapes.size() - 1) {
                allFigures.append(listOfShapes.get(i).toString()).append(", ");
            } else allFigures.append(listOfShapes.get(i));
        }
        return allFigures.toString();
    }

    public ArrayList<Shape> getListOfShapes() {
        return listOfShapes;
    }
}
