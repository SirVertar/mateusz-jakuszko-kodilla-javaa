package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> row;

    public SudokuRow(final int SIZE_OF_ROW) {
        row = createRow(SIZE_OF_ROW);
    }

    private List<SudokuElement> createRow(final int SIZE_OF_ROW) {
        List<SudokuElement> row = new ArrayList<>();
        for (int i = 0; i < SIZE_OF_ROW; i++) {
            row.add(new SudokuElement());
            row.get(row.size() - 1).setRowIndex(i);
        }
        return row;
    }

    public boolean isPossibleNumberInSomeOfElementsFieldInRow(SudokuRow sudokuRow, int possibleNumber) {
        for (SudokuElement sudokuElementInRow : sudokuRow.getRow()) {
            if (sudokuElementInRow.getNumberInElement() == possibleNumber) {
                return true;
            }
        }
        return false;
    }

    public boolean isPossibleNumberInOtherElementsPossibleNumbersArrayInRow(SudokuRow sudokuRow, int possibleNumber) {
        int quantityOfPossibleNumbersInOtherElements = -1;
        for (SudokuElement sudokuElementInRow : sudokuRow.getRow()) {
            if (sudokuElementInRow.getPossibleNumbers().contains(possibleNumber)) {
                quantityOfPossibleNumbersInOtherElements++;
            }
            if (quantityOfPossibleNumbersInOtherElements == 1) {
                return true;
            }
        }
        return false;
    }

    public List<SudokuElement> getRow() {
        return row;
    }
}
