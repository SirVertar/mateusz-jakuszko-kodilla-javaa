package com.kodilla.sudoku;

public class SudokuGame {

    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard();
//        sudokuBoard.getSudokuRows()[0].getRow().get(0).setFieldOfElement(2);
//        sudokuBoard.getSudokuRows()[0].getRow().get(3).setFieldOfElement(6);
//        sudokuBoard.getSudokuRows()[0].getRow().get(5).setFieldOfElement(7);
//        sudokuBoard.getSudokuRows()[0].getRow().get(6).setFieldOfElement(5);

//        sudokuBoard.getSudokuRows()[1].getRow().get(7).setFieldOfElement(9);
//        sudokuBoard.getSudokuRows()[1].getRow().get(8).setFieldOfElement(6);
//
//        sudokuBoard.getSudokuRows()[2].getRow().get(0).setFieldOfElement(6);
//        sudokuBoard.getSudokuRows()[2].getRow().get(2).setFieldOfElement(7);
//        sudokuBoard.getSudokuRows()[2].getRow().get(5).setFieldOfElement(1);
//        sudokuBoard.getSudokuRows()[2].getRow().get(6).setFieldOfElement(3);
//
//        sudokuBoard.getSudokuRows()[3].getRow().get(1).setFieldOfElement(5);
//        sudokuBoard.getSudokuRows()[3].getRow().get(3).setFieldOfElement(7);
//        sudokuBoard.getSudokuRows()[3].getRow().get(4).setFieldOfElement(3);
//        sudokuBoard.getSudokuRows()[3].getRow().get(5).setFieldOfElement(2);
//
//        sudokuBoard.getSudokuRows()[4].getRow().get(1).setFieldOfElement(7);
//        sudokuBoard.getSudokuRows()[4].getRow().get(7).setFieldOfElement(2);
//
//        sudokuBoard.getSudokuRows()[5].getRow().get(3).setFieldOfElement(1);
//        sudokuBoard.getSudokuRows()[5].getRow().get(4).setFieldOfElement(8);
//        sudokuBoard.getSudokuRows()[5].getRow().get(5).setFieldOfElement(9);
//        sudokuBoard.getSudokuRows()[5].getRow().get(7).setFieldOfElement(7);
//
//        sudokuBoard.getSudokuRows()[6].getRow().get(2).setFieldOfElement(3);
//        sudokuBoard.getSudokuRows()[6].getRow().get(3).setFieldOfElement(5);
//        sudokuBoard.getSudokuRows()[6].getRow().get(6).setFieldOfElement(6);
//        sudokuBoard.getSudokuRows()[6].getRow().get(8).setFieldOfElement(4);
//
//        sudokuBoard.getSudokuRows()[7].getRow().get(0).setFieldOfElement(8);
//        sudokuBoard.getSudokuRows()[7].getRow().get(1).setFieldOfElement(4);
//
//        sudokuBoard.getSudokuRows()[8].getRow().get(2).setFieldOfElement(5);
//        sudokuBoard.getSudokuRows()[8].getRow().get(3).setFieldOfElement(2);
//        sudokuBoard.getSudokuRows()[8].getRow().get(5).setFieldOfElement(6);
//        sudokuBoard.getSudokuRows()[8].getRow().get(8).setFieldOfElement(8);


        System.out.println(sudokuBoard);
        GameController gameController = new GameController(sudokuBoard);
        gameController.startGame();



    }
}
