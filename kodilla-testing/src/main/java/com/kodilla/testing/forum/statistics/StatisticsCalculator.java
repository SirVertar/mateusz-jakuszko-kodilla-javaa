package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private Object averageNumberOfPostsPerUser;
    private Object averageNumberOfCommentsPerUser;
    private Object averageNumberOfCommentsPerPost;


    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
        if (numberOfUsers > 0) {
            averageNumberOfPostsPerUser = (double) numberOfPosts / numberOfUsers;
        } else {
            averageNumberOfPostsPerUser = false;
            System.out.println("Sth wrong...probably there isn't any USERS");
        }
        if (numberOfUsers > 0) {
            averageNumberOfCommentsPerUser = (double) numberOfComments / numberOfUsers;
        } else {
            averageNumberOfCommentsPerUser = false;
            System.out.println("Sth wrong...probably there isn't any USERS");
        }
        if (numberOfPosts > 0) {
            averageNumberOfCommentsPerPost = (double) numberOfComments / numberOfPosts;
        } else {
            averageNumberOfCommentsPerPost = false;
            System.out.println("Sth wrong...probably there isn't any posts");
        }
    }


    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public Object getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public Object getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public Object getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }
}
