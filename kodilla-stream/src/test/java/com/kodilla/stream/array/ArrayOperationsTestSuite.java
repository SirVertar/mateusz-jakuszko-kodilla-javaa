package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] listOfNumbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        //When
        double expectedAverage = 10.5;

        //Then
        double resultAverage = ArrayOperations.getAverage(listOfNumbers);
        Assert.assertEquals(expectedAverage, resultAverage, 0);
    }
}
