package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;


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
        for (int i = 0; i < 136; i = i + 2) {
            arrayWithoutOdds.add(i);
        }
        //When
        ArrayList<Integer> testingArray = new ArrayList<>();
        for (int i = 0; i < 136; i++) {
            testingArray.add(i);
        }
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(testingArray);
        //Then
        Assert.assertArrayEquals(arrayWithoutOdds.toArray(), result.toArray());
    }
}
