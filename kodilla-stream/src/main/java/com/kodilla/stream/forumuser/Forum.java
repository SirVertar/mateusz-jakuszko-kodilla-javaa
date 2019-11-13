package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.*;

public final class Forum {

    private final List<ForumUser> listOfUsers = new ArrayList<>();

    public Forum() {
        ForumUser forumUser1 = new ForumUser(1, "Mateusz", 'M',
                LocalDate.of(1999,11,13 ), 12);
        ForumUser forumUser2 = new ForumUser(2, "Weronika", 'F',
                LocalDate.of(1995, 1, 10), 4);
        ForumUser forumUser3 = new ForumUser(3, "Beata", 'F',
                LocalDate.of(1990, 1, 5), 1);
        ForumUser forumUser4 = new ForumUser(4, "Piotr", 'M',
                LocalDate.of(2005, 5, 22), 1);
        ForumUser forumUser5 = new ForumUser(5, "Roman", 'M',
                LocalDate.of(1990, 1, 11), 1);
        ForumUser forumUser6 = new ForumUser(6, "Marysia", 'F',
                LocalDate.of(1998, 2, 20), 1);
        ForumUser forumUser7 = new ForumUser(7, "Piotr", 'M',
                LocalDate.of(2002, 9, 29), 0);
        ForumUser forumUser8 = new ForumUser(8, "Mati", 'M',
                LocalDate.of(2011, 6, 24), 1);

        listOfUsers.add(forumUser1);
        listOfUsers.add(forumUser2);
        listOfUsers.add(forumUser3);
        listOfUsers.add(forumUser4);
        listOfUsers.add(forumUser5);
        listOfUsers.add(forumUser6);
        listOfUsers.add(forumUser7);
        listOfUsers.add(forumUser8);
    }

    public List<ForumUser> getListOfUsers() {
        return listOfUsers;
    }

}
