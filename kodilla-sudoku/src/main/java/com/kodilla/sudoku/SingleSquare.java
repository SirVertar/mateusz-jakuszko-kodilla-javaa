package com.kodilla.sudoku;

public class SingleSquare {
    private Integer[] possibleNumbers;

    public SingleSquare() {
        possibleNumbers = new Integer[9];
    }

    public Integer[] getPossibleNumbers() {
        return possibleNumbers;
    }

    @Override
    public String toString() {
        return "[  ]";
    }
}
