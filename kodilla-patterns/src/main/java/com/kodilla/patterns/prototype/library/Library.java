package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = shallowCopy();
        Set<Book> clonedBooks = new HashSet<>();
        for (Book book: books) {
            clonedBooks.add(new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate()));
        }
        clonedLibrary.setBooks(clonedBooks);
        return clonedLibrary;
    }
}