package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Book book1 = new Book("Secrets of Alamo", "John Smith", LocalDate.of(2010, 12, 3));
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", LocalDate.of(1998, 8, 25));
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", LocalDate.of(1990, 7, 20));
        Library library = new Library("Library 1");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library shallowClonedLibrary = null;
        Library deepClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //When
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", LocalDate.of(2005, 6, 15));
        library.getBooks().add(book4);
        //Then
        Assert.assertNotNull(shallowClonedLibrary);
        Assert.assertNotNull(deepClonedLibrary);
        Assert.assertNotEquals(4, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(3,deepClonedLibrary.getBooks().size());
        Assert.assertEquals(4, shallowClonedLibrary.getBooks().size());
        Assert.assertArrayEquals(library.getBooks().toArray(), shallowClonedLibrary.getBooks().toArray());
    }
}
