package com.kodilla.sudoku;

public class BigSquare {
    private SingleSquare[][] bigSquare;

    public BigSquare(SingleSquare[][] bigSquare) {
        this.bigSquare = bigSquare;
    }

    public SingleSquare[][] getBigSquare() {
        return bigSquare;
    }
}
