package com.kodilla.sudoku;

public class SudokuGame {

    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows()[0].getRow().get(0).setNumberInElement(2);
        sudokuBoard.getSudokuRows()[0].getRow().get(3).setNumberInElement(6);
        sudokuBoard.getSudokuRows()[0].getRow().get(5).setNumberInElement(7);
        sudokuBoard.getSudokuRows()[0].getRow().get(6).setNumberInElement(5);

        sudokuBoard.getSudokuRows()[1].getRow().get(7).setNumberInElement(9);
        sudokuBoard.getSudokuRows()[1].getRow().get(8).setNumberInElement(6);

        sudokuBoard.getSudokuRows()[2].getRow().get(0).setNumberInElement(6);
        sudokuBoard.getSudokuRows()[2].getRow().get(2).setNumberInElement(7);
        sudokuBoard.getSudokuRows()[2].getRow().get(5).setNumberInElement(1);
        sudokuBoard.getSudokuRows()[2].getRow().get(6).setNumberInElement(3);

        sudokuBoard.getSudokuRows()[3].getRow().get(1).setNumberInElement(5);
        sudokuBoard.getSudokuRows()[3].getRow().get(3).setNumberInElement(7);
        sudokuBoard.getSudokuRows()[3].getRow().get(4).setNumberInElement(3);
        sudokuBoard.getSudokuRows()[3].getRow().get(5).setNumberInElement(2);

        sudokuBoard.getSudokuRows()[4].getRow().get(1).setNumberInElement(7);
        sudokuBoard.getSudokuRows()[4].getRow().get(7).setNumberInElement(2);

        sudokuBoard.getSudokuRows()[5].getRow().get(3).setNumberInElement(1);
        sudokuBoard.getSudokuRows()[5].getRow().get(4).setNumberInElement(8);
        sudokuBoard.getSudokuRows()[5].getRow().get(5).setNumberInElement(9);
        sudokuBoard.getSudokuRows()[5].getRow().get(7).setNumberInElement(7);

        sudokuBoard.getSudokuRows()[6].getRow().get(2).setNumberInElement(3);
        sudokuBoard.getSudokuRows()[6].getRow().get(3).setNumberInElement(5);
        sudokuBoard.getSudokuRows()[6].getRow().get(6).setNumberInElement(6);
        sudokuBoard.getSudokuRows()[6].getRow().get(8).setNumberInElement(4);

        sudokuBoard.getSudokuRows()[7].getRow().get(0).setNumberInElement(8);
        sudokuBoard.getSudokuRows()[7].getRow().get(1).setNumberInElement(4);

        sudokuBoard.getSudokuRows()[8].getRow().get(2).setNumberInElement(5);
        sudokuBoard.getSudokuRows()[8].getRow().get(3).setNumberInElement(2);
        sudokuBoard.getSudokuRows()[8].getRow().get(5).setNumberInElement(6);
        sudokuBoard.getSudokuRows()[8].getRow().get(8).setNumberInElement(8);




        System.out.println(sudokuBoard);

        GameController gameController = new GameController(sudokuBoard);
        gameController.startGame();
        System.out.println(sudokuBoard);
    }
}
