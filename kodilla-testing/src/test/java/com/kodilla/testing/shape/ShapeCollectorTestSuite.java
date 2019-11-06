package com.kodilla.testing.shape;

import org.junit.*;

import java.lang.reflect.AnnotatedArrayType;


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
        System.out.println("Start test number...  #" + counter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle();

        //When
        boolean result = shapeCollector.addFigure(triangle);

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testRemoveFigureEmptyList() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle();
        //When
        boolean result = shapeCollector.removeFigure(triangle);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle();
        shapeCollector.addFigure(triangle);

        //When
        boolean result = shapeCollector.removeFigure(triangle);

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testGetFigure() {
        //Given
        Shape triangle = new Triangle();
        Shape square = new Square();
        Shape circle = new Circle();
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);

        //When
        Shape result = shapeCollector.getFigure(2);

        //Then
        Assert.assertEquals(circle, result);
    }

    @Test
    public void testShowFigures() {
        //Given
        Shape triangle = new Triangle();
        Shape square = new Square();
        Shape circle = new Circle();
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);

        //When
        String result = shapeCollector.showFigures();

        //Then
        Assert.assertEquals("Triangle, Square, Circle", result);
    }
}
