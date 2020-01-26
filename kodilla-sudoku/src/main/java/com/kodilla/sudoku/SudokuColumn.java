package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuColumn {
    private List<SudokuElement> column;

    public SudokuColumn() {
        column = new ArrayList<>();
    }

    public List<SudokuElement> getColumn() {
        return column;
    }
}
