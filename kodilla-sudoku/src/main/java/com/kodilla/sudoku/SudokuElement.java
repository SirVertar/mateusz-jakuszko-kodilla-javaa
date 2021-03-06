package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuElement {
    private static int LAST_ELEMENT = 1;
    private List<Integer> possibleNumbers;
    private int id;
    private int empty = -1;
    private int fieldOfElement = -1;
    private int columnIndex = -1;
    private int rowIndex = -1;
    private int blockIndex = -1;


    public SudokuElement() {
        possibleNumbers = createPossibleNumbersSet();
        id = LAST_ELEMENT;
        LAST_ELEMENT++;
    }

    public List<Integer> createPossibleNumbersSet() {
        List<Integer> possibleNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 9)
                .forEach(possibleNumbers::add);
        return possibleNumbers;
    }

    public void removeNumberFromPossibleNumbers(Integer number) {
        possibleNumbers.remove(number);
    }

    public List<Integer> getPossibleNumbers() {
        return possibleNumbers;
    }

    public int getId() {
        return id;
    }

    public int getEmpty() {
        return empty;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getBlockIndex() {
        return blockIndex;
    }

    public int getFieldOfElement() {
        return fieldOfElement;
    }

    public void setColumnIndex(int columnIndex) {
        if (this.columnIndex == -1) {
            this.columnIndex = columnIndex;
        }
    }

    public void setRowIndex(int rowIndex) {
        if (this.rowIndex == -1) {
            this.rowIndex = rowIndex;
        }
    }

    public void setEmpty(int empty) {
        this.empty = empty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlockIndex(int blockIndex) {
        if (this.blockIndex == -1) {
            this.blockIndex = blockIndex;
        }
    }

    public static void setLastElement(int lastElement) {
        SudokuElement.LAST_ELEMENT = lastElement;
    }

    public void setFieldOfElement(int fieldOfElement) {
        empty = 1;
        this.fieldOfElement = fieldOfElement;
    }

    public void setPossibleNumbers(List<Integer> possibleNumbers) {
        this.possibleNumbers = possibleNumbers;
    }

    @Override
    public String toString() {
        if (empty != -1) {
            if (id % 3 == 0 && id % 9 != 0) {
                return " | " + fieldOfElement + " |      |  ";
            }
            return " | " + fieldOfElement + " |  ";
        }
        if (id % 3 == 0 && id % 9 != 0) {
            return " | " + " " + " |      |  ";
        }
        return " | " + " " + " |  ";
    }
}