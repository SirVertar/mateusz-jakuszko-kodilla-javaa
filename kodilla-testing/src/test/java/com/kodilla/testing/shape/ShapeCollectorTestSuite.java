package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {

    private static int counter = 0;

    @BeforeClass
    public static void beforeTests() {
        System.out.println("Test start");
    }
    @AfterClass
    public static void afterTests() {
        System.out.println("End of tests");
    }

    @Before
    public void beforeEveryTest() {
        counter++;
        System.out.println("Start test number...  #");
    }

    @After
    public void afterEveryTest() {
        System.out.println("Test ok");
    }

    @Test
    public void testGetShape() {
        //Given

        //When

        //Then
    }

    @Test
    public void testGeField() {
        //Given

        //When

        //Then
    }
}
