package com.kodilla.sudoku;

import java.util.*;

public class SudokuResolver {
    private SudokuBoard sudokuBoard;
    private boolean isBoardFull = false;
    private boolean isThereAnyOperation;
    private boolean isError = false;
    private Random random;

    public SudokuResolver(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        random = new Random();
    }

    public void resolveSudoku() {
        if (sudokuBoard.isThereErrorInBoard()) {
            System.out.println("There is a problem with sudoku. " +
                    "Probably there are repeating elements in rows, columns or blocks.");
            isBoardFull = true;
        }
        while (!isBoardFull) {
            isThereAnyOperation = false;
            for (int i = 0; i < sudokuBoard.getSudokuRows().length; i++) {
                SudokuRow sudokuRow = sudokuBoard.getSudokuRows()[i];
                for (SudokuElement sudokuElement : sudokuRow.getRow()) {
                    if (sudokuElement.getEmpty() == -1) {
                        Set<Integer> temporaryPossibleNumbers = new HashSet<>();
                        for (Integer possibleNumber : sudokuElement.getPossibleNumbers()) {
                            if (sudokuBoard.getSudokuRows()[sudokuElement.getRowIndex()]
                                    .isPossibleNumberInSomeOfElementsFieldInRow(sudokuRow, possibleNumber) ||
                                    sudokuBoard.getSudokuBlocks()[sudokuElement.getBlockIndex()]
                                            .isPossibleNumberInSomeOfElementsFieldInBlock(sudokuBoard, sudokuElement, possibleNumber) ||
                                    sudokuBoard.getSudokuColumns()[sudokuElement.getColumnIndex()]
                                            .isPossibleNumberInSomeOfElementsIFieldnColumn(sudokuBoard, sudokuElement, possibleNumber)) {
                                temporaryPossibleNumbers.add(possibleNumber);
                                isThereAnyOperation = true;
                                break;
                            }
                            if (!(sudokuBoard.getSudokuRows()[sudokuElement.getRowIndex()]
                                    .isPossibleNumberInOtherElementsPossibleNumbersArrayInRow(sudokuRow, possibleNumber) &&
                                    sudokuBoard.getSudokuColumns()[sudokuElement.getColumnIndex()]
                                            .isPossibleNumberInOtherElementsPossibleNumbersArrayInColumn(sudokuBoard, sudokuElement, possibleNumber) &&
                                    sudokuBoard.getSudokuBlocks()[sudokuElement.getBlockIndex()]
                                            .isPossibleNumberInOtherElementsPossibleNumbersArrayInBlock(sudokuBoard, sudokuElement, possibleNumber))) {
                                sudokuElement.setFieldOfElement(possibleNumber);
                                isThereAnyOperation = true;
                                break;
                            } else if (sudokuElement.getPossibleNumbers().size() == 1) {
                                int sizeOfBacktrack = sudokuBoard.getBacktrack().size();
                                if (sizeOfBacktrack > 0) {
                                    int rowIndexOfGuessedElement = sudokuBoard.getBacktrack().get(sizeOfBacktrack-1)
                                            .getRowNumberOfGuessedElement();
                                    int columnIndexOfGuessedElement = sudokuBoard.getBacktrack().get(sizeOfBacktrack-1)
                                            .getRowNumberOfGuessedElement();
                                    int guessedNumber = sudokuBoard.getBacktrack().get(sizeOfBacktrack-1)
                                            .getGuessedValueOfElement();
                                    SudokuElement guessedElement = sudokuBoard.getBacktrack().get(sizeOfBacktrack-1)
                                            .getSudokuBoard().getSudokuRows()[rowIndexOfGuessedElement]
                                            .getRow().get(columnIndexOfGuessedElement);
                                    setSudokuBoard(sudokuBoard.getBacktrack().get(sizeOfBacktrack-1).getSudokuBoard());
                                    guessedElement.removeNumberFromPossibleNumbers(guessedNumber);
                                    isThereAnyOperation = true;
                                    break;
                                } else {
                                    isError = true;
                                }
                            }
                        }
                        sudokuElement.getPossibleNumbers().removeAll(temporaryPossibleNumbers);
                        if (sudokuElement.getPossibleNumbers().size() == 1) {
                            for (Integer lastPossibleNumber : sudokuElement.getPossibleNumbers()) {
                                sudokuElement.setFieldOfElement(lastPossibleNumber);
                                isThereAnyOperation = true;
                                break;
                            }
                        }
                    }
                }
                isBoardFull = sudokuBoard.isBoardFull();
            }
            if (isError && !isBoardFull) {
                System.out.println("There is no possibility to resolve this sudoku... Probably I need to guess again");
                System.out.println(sudokuBoard);
                isError = false;
            }

            if (isBoardFull) {
                System.out.println("Final SUDOKU: ");
                System.out.println(sudokuBoard);
            }

            if (!isThereAnyOperation && !isBoardFull) {
                List<SudokuElement> listWithEmptySudokuElements = createListWithEmptySudokuElements();
                int randomEmptyElementIndex = random.nextInt(listWithEmptySudokuElements.size());
                SudokuElement randomSudokuElement = listWithEmptySudokuElements.get(randomEmptyElementIndex);
                int randomIndexOfPossibleNumberOfEmptyElement = random.nextInt(randomSudokuElement.getPossibleNumbers().size());
                int randomNumberFromPossibleNumbers = randomSudokuElement.getPossibleNumbers().get(randomIndexOfPossibleNumberOfEmptyElement);
                SudokuBoard clonedSudokuBoard = null;
                try {
                    clonedSudokuBoard = sudokuBoard.deepCopy();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                BacktrackData backtrackData = new BacktrackData(clonedSudokuBoard, randomSudokuElement.getRowIndex(),
                        randomSudokuElement.getColumnIndex(), randomNumberFromPossibleNumbers);
                sudokuBoard.getBacktrack().add(backtrackData);
                randomSudokuElement.setFieldOfElement(randomNumberFromPossibleNumbers);
            }
        }
    }

    private List<SudokuElement> createListWithEmptySudokuElements() {
        List<SudokuElement> listWithEmptySudokuElements = new ArrayList<>();
        for (int i = 0; i < sudokuBoard.getSudokuBlocks().length; i++) {
            for (SudokuElement sudokuElement: sudokuBoard.getSudokuBlocks()[i].getBlock()) {
                if (sudokuElement.getPossibleNumbers().size() == 0 && sudokuElement.getEmpty() == -1) {
                    sudokuElement.setPossibleNumbers(sudokuElement.createPossibleNumbersSet());
                }
                if (sudokuElement.getEmpty() == -1) {
                    listWithEmptySudokuElements.add(sudokuElement);
                }
            }
        }
        return listWithEmptySudokuElements;
    }

    private void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }
}
