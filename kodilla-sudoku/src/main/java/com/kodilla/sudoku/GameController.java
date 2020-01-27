package com.kodilla.sudoku;

import com.kodilla.sudoku.io.InputOutput;

public class GameController {
    private SudokuBoard sudokuBoard;
    private SudokuResolver sudokuResolver;
    private boolean isGameFinished = false;

    public GameController(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        this.sudokuResolver = new SudokuResolver(sudokuBoard);
    }

    public void startGame() {
        do {
            InputOutput.printOption();
            int choice = InputOutput.intInput(0, 2);
            switch (choice) {
                case 0:
                    sudokuResolver.resolveSudoku();
                    isGameFinished = true;
                    break;
                case 1:
                    int[] move = InputOutput.setElementField();
                    sudokuBoard.setFieldsInElement(move);
                    if (sudokuBoard.isThereErrorInBoard()) {
                        System.out.println("No way... You've probably gave a number which repeats in row, column or block");
                        sudokuBoard.removeFieldsInElement(move);
                    }
                    System.out.println(sudokuBoard);
                    break;
                case 2:
                    isGameFinished = true;
            }
        } while (!isGameFinished);
    }



}
