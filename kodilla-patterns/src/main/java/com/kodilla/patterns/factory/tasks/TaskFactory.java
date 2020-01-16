package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public Task createTask(String task) {
        switch (task) {
            case SHOPPING_TASK:
                return new ShoppingTask("Lidl", "Milk", 3);
            case PAINTING_TASK:
                return new PaintingTask("Paint a wall", "Black", "wall");
            case DRIVING_TASK:
                return new DrivingTask("Go to hospital", "Hospital", "VW Glof");
            default:
                return null;
        }

    }
}
