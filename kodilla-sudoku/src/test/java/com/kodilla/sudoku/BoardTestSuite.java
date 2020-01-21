package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

public class BoardTestSuite {
    @Test
    public void isBoardCreateProperlyTest() {
        //Given
        Board board = new Board();
        //When
        int numberOfBigSquaresInBoard = board.getBoard().length * board.getBoard()[2].length;
        int numberOfSingleSquaresInBigSquare = board.getBoard()[2][2].getBigSquare().length *
                board.getBoard()[2][2].getBigSquare()[2].length;
        int numberOfSingleSquaresInBoard = 0;
        for (BigSquare[] bigSquareTable : board.getBoard()) {
            for (BigSquare bigSquare : bigSquareTable) {
                for (SingleSquare[] singleSquaresTable : bigSquare.getBigSquare()) {
                    for (SingleSquare singleSquare : singleSquaresTable) {
                        numberOfSingleSquaresInBoard++;
                    }
                }
            }
        }
        //Then
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.getBoard()[1][1]);
        Assert.assertNotNull(board.getBoard()[1][1].getBigSquare());
        Assert.assertNotNull(board.getBoard()[1][1].getBigSquare()[1][1]);
        Assert.assertSame(board.getBoard()[1][1].getClass(), BigSquare.class);
        Assert.assertSame(board.getBoard()[1][1].getBigSquare()[1][1].getClass(), SingleSquare.class);
        Assert.assertEquals(9, numberOfBigSquaresInBoard);
        Assert.assertEquals(9, numberOfSingleSquaresInBigSquare);
        Assert.assertEquals(81, numberOfSingleSquaresInBoard);
    }
}
