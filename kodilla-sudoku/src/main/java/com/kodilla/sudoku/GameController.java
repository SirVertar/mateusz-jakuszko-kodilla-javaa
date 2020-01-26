package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class GameController {
    private SudokuBoard sudokuBoard;
    private boolean isBoardFull = false;
    private boolean isThereAnyOperation;

    public GameController(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public void startGame() {
        while (!isBoardFull) {
            isThereAnyOperation = false;
            for (int i = 0; i < sudokuBoard.getSudokuRows().length; i++) {
                SudokuRow sudokuRow = sudokuBoard.getSudokuRows()[i];
                for (SudokuElement sudokuElement : sudokuRow.getRow()) {
                    if (sudokuElement.getEmpty() == -1) {
                        Set<Integer> temporaryPossibleNumbers = new HashSet<>();
                        for (Integer possibleNumber : sudokuElement.getPossibleNumbers()) {
                            if (isElementInRow(sudokuRow, sudokuElement, possibleNumber) ||
                                    isElementInSudokuBlocks(sudokuElement, possibleNumber) ||
                                    isElementInColumn(sudokuElement, possibleNumber)) {
                                temporaryPossibleNumbers.add(possibleNumber);
                                isThereAnyOperation = true;
                            }
                        }
                        sudokuElement.getPossibleNumbers().removeAll(temporaryPossibleNumbers);
                        if (sudokuElement.getPossibleNumbers().size() == 1) {
                            for (Integer lastPossibleNumber : sudokuElement.getPossibleNumbers()) {
                                sudokuElement.setNumberInElement(lastPossibleNumber);
                                isThereAnyOperation = true;
                                break;
                            }
                        }
                        for (Integer possibleNumber : sudokuElement.getPossibleNumbers()) {
                            if (!(isTheSamePossibleNumberInOtherElementsInRow(sudokuRow, sudokuElement, possibleNumber) &&
                                    isTheSamePossibleNumberInOtherElementsInColumn(sudokuElement, possibleNumber) &&
                                    isTheSamePossibleNumberInOtherElementsInBlock(sudokuElement, possibleNumber))) {
                                sudokuElement.setNumberInElement(possibleNumber);
                                isThereAnyOperation = true;
                                break;
                            } else if (sudokuElement.getPossibleNumbers().size() == 1) {
                                System.out.println("ERRORRRRRRRRR :D");
                            }
                        }
                    }
                }
                isBoardFull = sudokuBoard.isBoardFull();
            }
            if (isThereAnyOperation) {
                System.out.println("WYKONANA OPERACJA");
                System.out.println(sudokuBoard);

            }
        }
    }

    public boolean isElementInRow(SudokuRow sudokuRow, SudokuElement sudokuElement, int possibleNumber) {
        for (SudokuElement sudokuElementInRow : sudokuRow.getRow()) {
            if (sudokuElementInRow.getNumberInElement() == possibleNumber) {
                return true;
            }
        }
        return false;
    }

    public boolean isElementInSudokuBlocks(SudokuElement sudokuElement, int possibleNumber) {
        SudokuBlock sudokuBlock = sudokuBoard.getSudokuBlocks()[sudokuElement.getBlockIndex()];
        for (SudokuElement sudokuElementInBlock : sudokuBlock.getSudokuBlock()) {
            if (sudokuElementInBlock.getNumberInElement() == possibleNumber) {
                return true;
            }
        }
        return false;
    }

    public boolean isElementInColumn(SudokuElement sudokuElement, int possibleNumber) {
        SudokuColumn sudokuColumn = sudokuBoard.getSudokuColumns()[sudokuElement.getColumnIndex()];
        for (SudokuElement sudokuElementInColumn : sudokuColumn.getColumn()) {
            if (sudokuElementInColumn.getNumberInElement() == possibleNumber) {
                return true;
            }
        }
        return false;
    }

    public boolean isTheSamePossibleNumberInOtherElementsInRow(SudokuRow sudokuRow, SudokuElement sudokuElement, int possibleNumber) {
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

    public boolean isTheSamePossibleNumberInOtherElementsInColumn(SudokuElement sudokuElement, int possibleNumber) {
        int quantityOfPossibleNumbersInOtherElements = -1;
        SudokuColumn sudokuColumn = sudokuBoard.getSudokuColumns()[sudokuElement.getColumnIndex()];
        for (SudokuElement sudokuElementInColumn : sudokuColumn.getColumn()) {
            if (sudokuElementInColumn.getNumberInElement() == possibleNumber) {
                return true;
            }
            if (sudokuElementInColumn.getPossibleNumbers().contains(possibleNumber)) {
                quantityOfPossibleNumbersInOtherElements++;
            }
            if (quantityOfPossibleNumbersInOtherElements == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isTheSamePossibleNumberInOtherElementsInBlock(SudokuElement sudokuElement, int possibleNumber) {
        int quantityOfPossibleNumbersInOtherElements = -1;
        SudokuBlock sudokuColumn = sudokuBoard.getSudokuBlocks()[sudokuElement.getBlockIndex()];
        for (SudokuElement sudokuElementInBlock : sudokuColumn.getSudokuBlock()) {
            if (sudokuElementInBlock.getNumberInElement() == possibleNumber) {
                return true;
            }
            if (sudokuElementInBlock.getPossibleNumbers().contains(possibleNumber)) {
                quantityOfPossibleNumbersInOtherElements++;
            }
            if (quantityOfPossibleNumbersInOtherElements == 1) {
                return true;
            }
        }
        return false;
    }
}
