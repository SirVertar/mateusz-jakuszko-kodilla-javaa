package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuBlock {
    private Set<SudokuElement> sudokuBlock;

    public SudokuBlock() {
        sudokuBlock = new HashSet<>();
    }

    public boolean isPossibleNumberInSomeOfElementsFieldInBlock(SudokuBoard sudokuBoard, SudokuElement sudokuElement, int possibleNumber) {
        SudokuBlock sudokuBlock = sudokuBoard.getSudokuBlocks()[sudokuElement.getBlockIndex()];
        for (SudokuElement sudokuElementInBlock : sudokuBlock.getSudokuBlock()) {
            if (sudokuElementInBlock.getNumberInElement() == possibleNumber) {
                return true;
            }
        }
        return false;
    }

    public boolean isPossibleNumberInOtherElementsPossibleNumbersArrayInBlock(SudokuBoard sudokuBoard, SudokuElement sudokuElement, int possibleNumber) {
        int quantityOfPossibleNumbersInOtherElements = -1;
        SudokuBlock sudokuBlock = sudokuBoard.getSudokuBlocks()[sudokuElement.getBlockIndex()];
        for (SudokuElement sudokuElementInBlock : sudokuBlock.getSudokuBlock()) {
            if (sudokuElementInBlock.getPossibleNumbers().contains(possibleNumber)) {
                quantityOfPossibleNumbersInOtherElements++;
            }
            if (quantityOfPossibleNumbersInOtherElements == 1) {
                return true;
            }
        }
        return false;
    }

    public Set<SudokuElement> getSudokuBlock() {
        return sudokuBlock;
    }
}
