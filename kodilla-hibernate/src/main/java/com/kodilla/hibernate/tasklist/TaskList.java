package com.kodilla.hibernate.tasklist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TASKLISTS")
@Access(AccessType.PROPERTY)
public class TaskList {
    private int id;
    private String listName;
    private String description;

    public TaskList(){

    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "LIST_NAME")
    public String getListName() {
        return listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListName(String lastName) {
        this.listName = lastName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
