package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Forum forum = new Forum();
        List<ForumUser> listOfUsers = forum.getListOfUsers();

        Map<Integer, ForumUser> resultMapOFUsers = listOfUsers.stream()
                .filter(p -> p.getSex() == 'M')
                .filter(p -> (LocalDate.now().getYear() - p.getDateOfBirth().getYear()) > 21 || (
                        LocalDate.now().getYear() - p.getDateOfBirth().getYear() == 20 &&
                                (LocalDate.now().getMonthValue() - p.getDateOfBirth().getMonthValue() > 0 ||
                                 (LocalDate.now().getMonthValue() - p.getDateOfBirth().getMonthValue() == 0 &&
                                  LocalDate.now().getDayOfMonth() - p.getDateOfBirth().getDayOfMonth() >= 0))))
                .filter(p -> p.getPostsNumber() > 0)
                .collect(Collectors.toMap(ForumUser::getId, p -> p));
        System.out.println("size of Map: " + resultMapOFUsers.size());

        resultMapOFUsers.entrySet().stream()
                .map(entry -> "ID:" + entry.getKey() + "____ " + entry.getValue())
                .forEach(System.out::println);
    }
}