package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void getLastLog() {
        //Given
        Logger logger = Logger.getInstance();
        logger.log("First Log");
        logger.log("Second Log");
        //When
        String lastLog = logger.getLastLog();
        //Then
        Assert.assertEquals("Second Log", lastLog);
    }

    @Test
    public void checkIsThereOnlyOneObject() {
        //Given
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();
        //When
        logger1.log("First log");
        logger2.log("Second log");
        logger3.log("Third log");
        //Then
        Assert.assertEquals(logger1.getLastLog(), logger2.getLastLog());
        Assert.assertEquals(logger1.getLastLog(), logger3.getLastLog());
        Assert.assertEquals("Third log", logger1.getLastLog());
    }
}
