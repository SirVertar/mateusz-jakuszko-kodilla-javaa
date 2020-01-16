package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void createTasksTest() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPING_TASK);
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTING_TASK);
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVING_TASK);
        //When
        String whatToBuy = ((ShoppingTask)shoppingTask).getWhatToBuy();
        String whatToPaint = ((PaintingTask)paintingTask).getColor();
        String whereGetTo = ((DrivingTask)drivingTask).getWhere();
        //Then
        Assert.assertEquals("Milk", whatToBuy);
        Assert.assertEquals("Black", whatToPaint);
        Assert.assertEquals("Hospital", whereGetTo);
    }

    @Test
    public void checkIsTaskExecuted() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPING_TASK);
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTING_TASK);
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVING_TASK);
        //When
        shoppingTask.executeTask();
        paintingTask.executeTask();
        //Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
        Assert.assertTrue(paintingTask.isTaskExecuted());
        Assert.assertFalse(drivingTask.isTaskExecuted());
    }

}
