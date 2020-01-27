package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuElement {
    private List<Integer> possibleNumbers;
    private static int lastElementNumber = 1;
    private int id;
    private int empty = -1;
    private int numberInElement;
    private int columnIndex = -1;
    private int rowIndex = -1;
    private int blockIndex = -1;


    public SudokuElement() {
        possibleNumbers = createPossibleNumbersSet();
        id = lastElementNumber;
        lastElementNumber++;
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

    public int getNumberInElement() {
        return numberInElement;
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

    public static void setLastElementNumber(int lastElementNumber) {
        SudokuElement.lastElementNumber = lastElementNumber;
    }

    public void setNumberInElement(int numberInElement) {
        empty = 1;
        this.numberInElement = numberInElement;
    }

    public void setPossibleNumbers(List<Integer> possibleNumbers) {
        this.possibleNumbers = possibleNumbers;
    }

    @Override
    public String toString() {
        if (empty != -1) {
            if (id % 3 == 0 && id % 9 != 0) {
                return " | " + numberInElement + " |      |  ";
            }
            return " | " + numberInElement + " |  ";
        }
        if (id % 3 == 0 && id % 9 != 0) {
            return " | " + " " + " |      |  ";
        }
        return " | " + " " + " |  ";
    }
}