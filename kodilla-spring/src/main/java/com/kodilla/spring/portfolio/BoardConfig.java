package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Bean(name = "Task List")
    @Scope("prototype")
    public TaskList getTaskList() {
        return new TaskList();
    }


    @Bean Board getBoard() {
        return new Board(getTaskList(), getTaskList(), getTaskList());
    }

}
