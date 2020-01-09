package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testOfCreatingBeans() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        boolean isThereTaskList = context.containsBean("Task List");
        boolean isThereBoard = context.containsBean("getBoard");
        //Then
        Assert.assertTrue(isThereTaskList);
        Assert.assertTrue(isThereBoard);
    }

    @Test
    public void testGetLists() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getDoneList().addTask("Clean bicycle");

        board.getInProgressList().addTask("Do notes");
        board.getInProgressList().addTask("Clean car");

        board.getToDoList().addTask("Wash your hands");
        board.getToDoList().addTask("Go to Bangkok");
        board.getToDoList().addTask("Clean room");
        //When
        TaskList doneList = board.getDoneList();
        TaskList inProgressList = board.getInProgressList();
        TaskList toDoList = board.getToDoList();
        //Then
        Assert.assertEquals(Collections.singletonList("Clean bicycle"), doneList.getTasks());
        Assert.assertEquals(Arrays.asList("Do notes", "Clean car"), inProgressList.getTasks());
        Assert.assertEquals(Arrays.asList("Wash your hands", "Go to Bangkok", "Clean room"), toDoList.getTasks());
    }

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getDoneList().addTask("Clean bicycle");
        board.getDoneList().addTask("Clean house");
        board.getInProgressList().addTask("Do notes");
        board.getInProgressList().addTask("Clean car");
        board.getToDoList().addTask("Wash your hands");
        board.getToDoList().addTask("Go to Bangkok");
        board.getToDoList().addTask("Clean room");
        //When
        TaskList doneList = board.getDoneList();
        TaskList inProgressList = board.getInProgressList();
        TaskList toDoList = board.getToDoList();
        //Then
        Assert.assertEquals("Clean bicycle", doneList.getTasks().get(doneList.getTasks().size() - 2));
        Assert.assertEquals("Clean house", doneList.getTasks().get(doneList.getTasks().size() - 1));
        Assert.assertEquals("Do notes", inProgressList.getTasks().get(inProgressList.getTasks().size() - 2));
        Assert.assertEquals("Clean car", inProgressList.getTasks().get(inProgressList.getTasks().size() - 1));
        Assert.assertEquals("Wash your hands", toDoList.getTasks().get(toDoList.getTasks().size() - 3));
        Assert.assertEquals("Go to Bangkok", toDoList.getTasks().get(toDoList.getTasks().size() - 2));
        Assert.assertEquals("Clean room", toDoList.getTasks().get(toDoList.getTasks().size() - 1));
    }
}
