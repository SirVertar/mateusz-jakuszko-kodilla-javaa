package com.kodilla.sudoku;

public class Board {
    private SingleSquare[][] board;

    public Board() {
        board = new SingleSquare[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = new SingleSquare();
            }
        }
        
    }

    public SingleSquare[][] getBoard() {
        return board;
    }


    @Override
    public String toString() {

        return "a";
    }
}
