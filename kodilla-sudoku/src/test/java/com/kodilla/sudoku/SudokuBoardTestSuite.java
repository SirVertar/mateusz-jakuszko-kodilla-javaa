package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SudokuBoardTestSuite {

    @Test
    public void createRowsTest() {
        //Given
        SudokuElement.setLastElementNumber(1);
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuRow[] sudokuRows = sudokuBoard.getSudokuRows();
        //When
        int numberOfSudokuRows = sudokuRows.length;
        List<Integer> listOfFirstRowElementsIds = new ArrayList<>();
        List<Integer> expectedListOfFirstRowElementsIds = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            expectedListOfFirstRowElementsIds.add(i+1);
            listOfFirstRowElementsIds.add(sudokuRows[0].getRow().get(i).getId());
        }
        //Then
        Assert.assertEquals(9, numberOfSudokuRows);
        Assert.assertEquals(expectedListOfFirstRowElementsIds, listOfFirstRowElementsIds);

    }

    @Test
    public void createSudokuBlockTest() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuBlock[] sudokuBlocks = sudokuBoard.getSudokuBlocks();
        Set<SudokuElement> sudokuBlock = sudokuBlocks[1].getSudokuBlock();
        //When
        int numberOfSudokuBlocks = sudokuBlocks.length;
        int sizeOfBlock = sudokuBlock.size();
        Set<SudokuElement> expectedSetOfElements = new HashSet<>();
        expectedSetOfElements.add(sudokuBoard.getSudokuRows()[0].getRow().get(3));
        expectedSetOfElements.add(sudokuBoard.getSudokuRows()[0].getRow().get(4));
        expectedSetOfElements.add(sudokuBoard.getSudokuRows()[0].getRow().get(5));
        expectedSetOfElements.add(sudokuBoard.getSudokuRows()[1].getRow().get(3));
        expectedSetOfElements.add(sudokuBoard.getSudokuRows()[1].getRow().get(4));
        expectedSetOfElements.add(sudokuBoard.getSudokuRows()[1].getRow().get(5));
        expectedSetOfElements.add(sudokuBoard.getSudokuRows()[2].getRow().get(3));
        expectedSetOfElements.add(sudokuBoard.getSudokuRows()[2].getRow().get(4));
        expectedSetOfElements.add(sudokuBoard.getSudokuRows()[2].getRow().get(5));
        //Then
        Assert.assertEquals(9, numberOfSudokuBlocks);
        Assert.assertEquals(9, sizeOfBlock);
        Assert.assertTrue(sudokuBlock.containsAll(expectedSetOfElements));

    }

    @Test
    public void createSudokuColumnsTest() {
        //Given
        SudokuElement.setLastElementNumber(1);
        SudokuBoard sudokuBoard = new SudokuBoard();
        //When
        int numberOfColumns = sudokuBoard.getSudokuColumns().length;
        int firstIdOfElement = sudokuBoard.getSudokuColumns()[5].getColumn().get(6).getId();
        int secondIdOfElement = sudokuBoard.getSudokuColumns()[0].getColumn().get(4).getId();
        int thirdIdOfElement = sudokuBoard.getSudokuColumns()[8].getColumn().get(6).getId();
        int fourthIdOfElement = sudokuBoard.getSudokuColumns()[7].getColumn().get(1).getId();
        int fifthIdOfElement = sudokuBoard.getSudokuColumns()[1].getColumn().get(1).getId();
        //Then
        Assert.assertEquals(9, numberOfColumns);
        Assert.assertEquals(60, firstIdOfElement);
        Assert.assertEquals(37, secondIdOfElement);
        Assert.assertEquals(63, thirdIdOfElement);
        Assert.assertEquals(17, fourthIdOfElement);
        Assert.assertEquals(11, fifthIdOfElement);
    }

    @Test
    public void shallowCloneTest() {
        //Given
        SudokuElement.setLastElementNumber(1);
        SudokuBoard sudokuBoard = new SudokuBoard();
        //When
        sudokuBoard.getSudokuRows()[0].getRow().get(1).setNumberInElement(5);
        sudokuBoard.getSudokuRows()[5].getRow().get(4).setNumberInElement(3);
        sudokuBoard.getSudokuRows()[7].getRow().get(3).setNumberInElement(1);

        SudokuBoard clonedSudokuBoard = null;
        try {
            clonedSudokuBoard = sudokuBoard.shallowCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        assert clonedSudokuBoard != null;
        clonedSudokuBoard.getSudokuRows()[0].getRow().get(1).setNumberInElement(2);
        clonedSudokuBoard.getSudokuRows()[5].getRow().get(4).setNumberInElement(8);
        clonedSudokuBoard.getSudokuRows()[7].getRow().get(3).setNumberInElement(4);

        //Then
        Assert.assertNotEquals(5, sudokuBoard.getSudokuRows()[0].getRow().get(1).getNumberInElement());
        Assert.assertNotEquals(3, sudokuBoard.getSudokuRows()[5].getRow().get(4).getNumberInElement());
        Assert.assertNotEquals(1, sudokuBoard.getSudokuRows()[7].getRow().get(3).getNumberInElement());
        Assert.assertEquals(2, sudokuBoard.getSudokuRows()[0].getRow().get(1).getNumberInElement());
        Assert.assertEquals(8, sudokuBoard.getSudokuRows()[5].getRow().get(4).getNumberInElement());
        Assert.assertEquals(4, sudokuBoard.getSudokuRows()[7].getRow().get(3).getNumberInElement());
        Assert.assertEquals(2, clonedSudokuBoard.getSudokuRows()[0].getRow().get(1).getNumberInElement());
        Assert.assertEquals(8, clonedSudokuBoard.getSudokuRows()[5].getRow().get(4).getNumberInElement());
        Assert.assertEquals(4, clonedSudokuBoard.getSudokuRows()[7].getRow().get(3).getNumberInElement());
        Assert.assertNotEquals(5, clonedSudokuBoard.getSudokuRows()[0].getRow().get(1).getNumberInElement());
        Assert.assertNotEquals(3, clonedSudokuBoard.getSudokuRows()[5].getRow().get(4).getNumberInElement());
        Assert.assertNotEquals(1, clonedSudokuBoard.getSudokuRows()[7].getRow().get(3).getNumberInElement());
    }

    @Test
    public void deepCloneTest() {
        //Given
        SudokuElement.setLastElementNumber(1);
        SudokuBoard sudokuBoard = new SudokuBoard();
        //When
        sudokuBoard.getSudokuRows()[0].getRow().get(1).setNumberInElement(5);
        sudokuBoard.getSudokuRows()[5].getRow().get(4).setNumberInElement(3);
        sudokuBoard.getSudokuRows()[7].getRow().get(3).setNumberInElement(1);

        SudokuBoard clonedSudokuBoard = null;
        try {
            clonedSudokuBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        assert clonedSudokuBoard != null;
        clonedSudokuBoard.getSudokuRows()[0].getRow().get(1).setNumberInElement(2);
        clonedSudokuBoard.getSudokuRows()[5].getRow().get(4).setNumberInElement(8);
        clonedSudokuBoard.getSudokuRows()[7].getRow().get(3).setNumberInElement(4);

        //Then
        Assert.assertEquals(5, sudokuBoard.getSudokuRows()[0].getRow().get(1).getNumberInElement());
        Assert.assertEquals(3, sudokuBoard.getSudokuRows()[5].getRow().get(4).getNumberInElement());
        Assert.assertEquals(1, sudokuBoard.getSudokuRows()[7].getRow().get(3).getNumberInElement());
        Assert.assertEquals(2, clonedSudokuBoard.getSudokuRows()[0].getRow().get(1).getNumberInElement());
        Assert.assertEquals(8, clonedSudokuBoard.getSudokuRows()[5].getRow().get(4).getNumberInElement());
        Assert.assertEquals(4, clonedSudokuBoard.getSudokuRows()[7].getRow().get(3).getNumberInElement());
        Assert.assertNotEquals(5, clonedSudokuBoard.getSudokuRows()[0].getRow().get(1).getNumberInElement());
        Assert.assertNotEquals(3, clonedSudokuBoard.getSudokuRows()[5].getRow().get(4).getNumberInElement());
        Assert.assertNotEquals(1, clonedSudokuBoard.getSudokuRows()[7].getRow().get(3).getNumberInElement());
    }

}
