package com.kodilla.testing.shape;

import org.junit.*;

import java.lang.reflect.AnnotatedArrayType;


public class ShapesTestSuite {

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
    public void testGetShapeName() {
        //Given
        Shape triangle = new Triangle();
        Shape square = new Square();
        Shape circle = new Circle();

        //When
        String resultOfTriangleName = triangle.getShapeName();
        String resultOfSquareName = square.getShapeName();
        String resultOfCircleName = circle.getShapeName();

        //Then
        Assert.assertEquals("Triangle", resultOfTriangleName);
        Assert.assertEquals("Square", resultOfSquareName);
        Assert.assertEquals("Circle", resultOfCircleName);
    }

    @Test
    public void testGeField() {
        //Given
        Shape triangle = new Triangle(3,4);
        Shape square = new Square(5);
        Shape circle = new Circle(3);

        //When
        double resultOfTriangleField = triangle.getField();
        double resultOfSquareField = square.getField();
        double resultOfCircleField = circle.getField();

        //Then
        Assert.assertEquals(6, triangle.getField(),0);
        Assert.assertEquals(25, square.getField(),0);
        Assert.assertEquals(9*Math.PI, circle.getField(),0);

    }
}
