package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype {
    private SudokuRow[] sudokuRows;
    private SudokuColumn[] sudokuColumns;
    private SudokuBlock[] sudokuBlocks;
    private List<BacktrackData> backtrack;
    private static final int NUMBER_OF_ROWS = 9;
    private static final int NUMBER_OF_COLUMNS = 9;
    private static final int NUMBER_OF_SQUARES = 9;

    public SudokuBoard() {
        sudokuRows = createRows();
        sudokuBlocks = createSudokuBlocks(sudokuRows);
        sudokuColumns = createSudokuColumns(sudokuRows);
        backtrack = new ArrayList<>();
    }

    private SudokuRow[] createRows() {
        SudokuRow[] board = new SudokuRow[NUMBER_OF_ROWS];
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            board[i] = new SudokuRow(NUMBER_OF_COLUMNS);
        }
        return board;
    }

    private SudokuBlock[] createSudokuBlocks(SudokuRow[] sudokuRows) {
        SudokuBlock[] sudokuBlocks = new SudokuBlock[9];
        for (int i = 0; i < NUMBER_OF_SQUARES; i++) {
            sudokuBlocks[i] = new SudokuBlock();
        }
        for (int i = 0; i < sudokuRows.length; i++) {
            if (i <= 2) {
                setSudokuBlocks(i, sudokuBlocks, sudokuRows[i].getRow(), 0, sudokuRows);
            }
            if (i >= 3 && i <= 5) {
                setSudokuBlocks(i, sudokuBlocks, sudokuRows[i].getRow(), 3, sudokuRows);
            }
            if (i >= 6 && i <= 8) {
                setSudokuBlocks(i, sudokuBlocks, sudokuRows[i].getRow(), 6, sudokuRows);
            }
        }
        return sudokuBlocks;
    }

    private void setSudokuBlocks(int numberOfRow, SudokuBlock[] sudokuBlocks, List<SudokuElement> row,
                                 int numberOfStartBigSquare, SudokuRow[] sudokuRows) {
        for (int j = 0; j < row.size(); j++) {
            switch (j) {
                case 0:
                case 1:
                case 2:
                    sudokuRows[numberOfRow].getRow().get(j).setBlockIndex(numberOfStartBigSquare);
                    sudokuBlocks[numberOfStartBigSquare].getBlock().add(sudokuRows[numberOfRow].getRow().get(j));
                    break;
                case 3:
                case 4:
                case 5:
                    sudokuRows[numberOfRow].getRow().get(j).setBlockIndex(numberOfStartBigSquare + 1);
                    sudokuBlocks[numberOfStartBigSquare + 1].getBlock().add(sudokuRows[numberOfRow].getRow().get(j));
                    break;
                case 6:
                case 7:
                case 8:
                    sudokuRows[numberOfRow].getRow().get(j).setBlockIndex(numberOfStartBigSquare + 2);
                    sudokuBlocks[numberOfStartBigSquare + 2].getBlock().add(sudokuRows[numberOfRow].getRow().get(j));
                    break;
            }
        }
    }

    private SudokuColumn[] createSudokuColumns(SudokuRow[] sudokuRows) {
        SudokuColumn[] sudokuColumns = new SudokuColumn[NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            sudokuColumns[i] = new SudokuColumn();
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                sudokuColumns[i].getColumn().add(sudokuRows[j].getRow().get(i));
                sudokuRows[j].getRow().get(i).setColumnIndex(i);
            }
        }
        return sudokuColumns;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            for (SudokuElement sudokuElement : sudokuRows[i].getRow()) {
                if (sudokuElement.getEmpty() == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isThereErrorInBoard() {
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            if (sudokuRows[i].isRepeatingFieldsOfElementsInRow() ||
                    sudokuBlocks[i].isRepeatingFieldsOfElementsInBlock() ||
                    sudokuColumns[i].isRepeatingFieldsOfElementsInColumn()) {
                return true;
            }
        }
        return false;
    }

    public void setFieldsInElement(int[] choice) {
        int rowNumber = -1;
        int columnNumber = -1;
        int fieldNumber = -1;
        for (int i = 0; i < choice.length; i++) {
            switch (i) {
                case 0:
                    rowNumber = choice[i];
                case 1:
                    columnNumber = choice[i];
                case 2:
                    fieldNumber = choice[i];
            }
        }
        this.getSudokuRows()[rowNumber-1].getRow().get(columnNumber-1).setFieldOfElement(fieldNumber);
    }

    public void removeFieldsInElement(int[] choice) {
        int rowNumber = -1;
        int columnNumber = -1;
        for (int i = 0; i < choice.length; i++) {
            switch (i) {
                case 0:
                    rowNumber = choice[i];
                case 1:
                    columnNumber = choice[i];
            }
        }
        this.getSudokuRows()[rowNumber-1].getRow().get(columnNumber-1).setFieldOfElement(-1);
        this.getSudokuRows()[rowNumber-1].getRow().get(columnNumber-1).setEmpty(-1);
    }

    public SudokuBoard shallowCopy() throws CloneNotSupportedException {
        return (SudokuBoard) super.clone();
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedSudokuBoard = (SudokuBoard) super.clone();
        SudokuElement.setLastElement(1);
        clonedSudokuBoard.sudokuRows = new SudokuRow[NUMBER_OF_ROWS];
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            clonedSudokuBoard.sudokuRows[i] = new SudokuRow(NUMBER_OF_COLUMNS);
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                clonedSudokuBoard.sudokuRows[i].getRow().get(j).setPossibleNumbers(sudokuRows[i].getRow().get(j).getPossibleNumbers());
                clonedSudokuBoard.sudokuRows[i].getRow().get(j).setFieldOfElement(sudokuRows[i].getRow().get(j).getFieldOfElement());
                clonedSudokuBoard.sudokuRows[i].getRow().get(j).setBlockIndex(sudokuRows[i].getRow().get(j).getBlockIndex());
                clonedSudokuBoard.sudokuRows[i].getRow().get(j).setRowIndex(sudokuRows[i].getRow().get(j).getRowIndex());
                clonedSudokuBoard.sudokuRows[i].getRow().get(j).setColumnIndex(sudokuRows[i].getRow().get(j).getColumnIndex());
                clonedSudokuBoard.sudokuRows[i].getRow().get(j).setEmpty(sudokuRows[i].getRow().get(j).getEmpty());
                clonedSudokuBoard.sudokuRows[i].getRow().get(j).setId(sudokuRows[i].getRow().get(j).getId());
            }
        }
        clonedSudokuBoard.sudokuColumns = createSudokuColumns(clonedSudokuBoard.sudokuRows);
        clonedSudokuBoard.sudokuBlocks = createSudokuBlocks(clonedSudokuBoard.sudokuRows);
        clonedSudokuBoard.backtrack = new ArrayList<>();
        clonedSudokuBoard.backtrack.addAll(backtrack);

        return clonedSudokuBoard;
    }

    public SudokuRow[] getSudokuRows() {
        return sudokuRows;
    }

    public SudokuColumn[] getSudokuColumns() {
        return sudokuColumns;
    }

    public SudokuBlock[] getSudokuBlocks() {
        return sudokuBlocks;
    }

    public List<BacktrackData> getBacktrack() {
        return backtrack;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-------------------------------------------------------------------------------------\n\n");
        for (int i = 0; i < sudokuRows.length; i++) {
            for (int j = 0; j < sudokuRows[i].getRow().size(); j++) {
                if (j == 2 || j == 5) {
                    stringBuilder.append(sudokuRows[i].getRow().get(j) + "   ");
                } else {
                    stringBuilder.append(sudokuRows[i].getRow().get(j) + "\b");
                }
            }
            if (i == 2 || i == 5 || i == 8) {
                stringBuilder.append("\n\n------------------------------------------------------------------------------------\n\n");
            } else {
                stringBuilder.append("\n--------------------      |      -------------------      |      --------------------\n");
            }
        }
        return stringBuilder.toString();
    }
}
