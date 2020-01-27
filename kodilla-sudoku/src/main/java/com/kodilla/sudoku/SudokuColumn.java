package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuColumn {
    private List<SudokuElement> column;

    public SudokuColumn() {
        column = new ArrayList<>();
    }

    public boolean isPossibleNumberInSomeOfElementsIFieldnColumn(SudokuBoard sudokuBoard, SudokuElement sudokuElement, int possibleNumber) {
        SudokuColumn sudokuColumn = sudokuBoard.getSudokuColumns()[sudokuElement.getColumnIndex()];
        for (SudokuElement sudokuElementInColumn : sudokuColumn.getColumn()) {
            if (sudokuElementInColumn.getNumberInElement() == possibleNumber) {
                return true;
            }
        }
        return false;
    }

    public boolean isPossibleNumberInOtherElementsPossibleNumbersArrayInColumn(SudokuBoard sudokuBoard, SudokuElement sudokuElement, int possibleNumber) {
        int quantityOfPossibleNumbersInOtherElements = -1;
        SudokuColumn sudokuColumn = sudokuBoard.getSudokuColumns()[sudokuElement.getColumnIndex()];
        for (SudokuElement sudokuElementInColumn : sudokuColumn.getColumn()) {
            if (sudokuElementInColumn.getPossibleNumbers().contains(possibleNumber)) {
                quantityOfPossibleNumbersInOtherElements++;
            }
            if (quantityOfPossibleNumbersInOtherElements == 1) {
                return true;
            }
        }
        return false;
    }

    public List<SudokuElement> getColumn() {
        return column;
    }
}
