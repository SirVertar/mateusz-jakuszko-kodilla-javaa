package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void createShoppingTaskTest() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPING_TASK);
        //When
        String whatToBuy = ((ShoppingTask)shoppingTask).getWhatToBuy();
        shoppingTask.executeTask();
        //Then
        Assert.assertEquals("Milk", whatToBuy);
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    public void createPaintingTaskTest() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTING_TASK);
        //When
        String whatToPaint = ((PaintingTask)paintingTask).getColor();
        paintingTask.executeTask();
        //Then
        Assert.assertEquals("Black", whatToPaint);
        Assert.assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    public void createDrivingTaskTest() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVING_TASK);
        //When
        String whereGetTo = ((DrivingTask)drivingTask).getWhere();
        drivingTask.executeTask();
        //Then
        Assert.assertEquals("Hospital", whereGetTo);
        Assert.assertTrue(drivingTask.isTaskExecuted());
    }
}
