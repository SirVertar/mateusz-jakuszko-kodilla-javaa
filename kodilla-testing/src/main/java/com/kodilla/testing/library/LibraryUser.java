package com.kodilla.testing.library;

import java.util.*;

public class LibraryUser {
    private String firstname;
    private String lastname;
    private String peselId;

    public LibraryUser(String firstname, String lastname, String peselId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.peselId = peselId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPeselId() {
        return peselId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(peselId, that.peselId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, peselId);
    }
}
