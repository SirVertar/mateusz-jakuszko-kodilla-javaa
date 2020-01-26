package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> row;
    private static final int SIZE_OF_ROW = 9;

    public SudokuRow(int numberOfRow) {
        row = createRow();
    }

    private List<SudokuElement> createRow() {
        List<SudokuElement> row = new ArrayList<>();
        for (int i = 0; i < SIZE_OF_ROW; i++) {
            row.add(new SudokuElement());
            row.get(row.size() - 1).setRowIndex(i);
        }
        return row;
    }

    public boolean isElementInRow(SudokuRow sudokuRow, int possibleNumber) {
        for (SudokuElement sudokuElementInRow : sudokuRow.getRow()) {
            if (sudokuElementInRow.getNumberInElement() == possibleNumber) {
                return true;
            }
        }
        return false;
    }

    public List<SudokuElement> getRow() {
        return row;
    }
}
