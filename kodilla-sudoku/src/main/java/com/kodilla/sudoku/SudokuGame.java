package com.kodilla.sudoku;

public class SudokuGame {

    public static void main(String[] args) {
        Board board = new Board();
        Integer[][] result = board.createTable();


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(result[i][j] + "   ");
                if (j == 8) {
                    System.out.println();
                }
            }
        }
    }
}
