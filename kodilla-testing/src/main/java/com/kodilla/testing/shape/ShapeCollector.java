package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> listOfShapes = new ArrayList<Shape>();

    public boolean addFigure(Shape shape) {
        if(shape != null) {
            listOfShapes.add(shape);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeFigure(Shape shape) {
        if(listOfShapes.indexOf(shape) >= 0) {
            int index = listOfShapes.indexOf(shape);
            listOfShapes.remove(index);
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
        for (int i = 0; i < listOfShapes.size() ; i++) {
            if (i<listOfShapes.size()-1) {
                allFigures.append(listOfShapes.get(i).toString() + ", ");
            } else allFigures.append(listOfShapes.get(i));
        }
        String result = allFigures.toString();
        return result;
    }

    public ArrayList<Shape> getListOfShapes() {
        return listOfShapes;
    }
}
