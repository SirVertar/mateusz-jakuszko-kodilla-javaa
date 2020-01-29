package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("TO_DO_LIST", "THINGS TO DO");

        //When
        taskListDao.save(taskList);

        //Then
        String listName = taskList.getListName();
        List<TaskList> loadedList = taskListDao.findByListName(listName);
        Assert.assertEquals("TO_DO_LIST", loadedList.get(0).getListName());

        //Clean up
        taskListDao.deleteAll();
    }
}
