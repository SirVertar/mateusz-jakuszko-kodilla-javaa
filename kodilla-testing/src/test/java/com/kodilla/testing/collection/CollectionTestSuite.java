package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;


public class CollectionTestSuite {
    @Before
    public void BeforeTest() {
        System.out.println("Test start...");
    }

    @After
    public void AfterTest() {
        System.out.println("Test ends...");
    }

    @AfterClass
    public static void AfterSuite() {
        System.out.println("Finally end all suite...");
    }

    @BeforeClass
    public static void BeforeSuite() {
        System.out.println("Start suites...");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        System.out.println("Testing with empty list...");
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyArray = new ArrayList<Integer>();

        //When
        ArrayList result = oddNumbersExterminator.exterminate(emptyArray);

        //Then
        Assert.assertEquals(emptyArray.size(), result.size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        System.out.println("Testing with normal list...");
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> arrayWithoutOdds = new ArrayList<>();
        arrayWithoutOdds.add(44);
        arrayWithoutOdds.add(66);
        arrayWithoutOdds.add(98);

        ArrayList<Integer> testingArray = new ArrayList<>();
        testingArray.add(33);
        testingArray.add(44);
        testingArray.add(66);
        testingArray.add(11);
        testingArray.add(21);
        testingArray.add(98);
        testingArray.add(9999911);

        //When
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(testingArray);

        //Then
        Assert.assertArrayEquals(arrayWithoutOdds.toArray(), result.toArray());
    }
}
