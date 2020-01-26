package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuBlock {
    private Set<SudokuElement> sudokuBlock;

    public SudokuBlock() {
        sudokuBlock = new HashSet<>();
    }

    public Set<SudokuElement> getSudokuBlock() {
        return sudokuBlock;
    }
}
