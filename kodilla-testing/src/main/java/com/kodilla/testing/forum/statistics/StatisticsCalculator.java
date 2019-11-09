package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averageNumberOfPostsPerUser = 0.0;
    private double averageNumberOfCommentsPerUser = 0.0;
    private double averageNumberOfCommentsPerPost = 0.0;


    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
        if (numberOfUsers > 0) {
            averageNumberOfPostsPerUser = (double) numberOfPosts / numberOfUsers;
        } else {
            System.out.println("Sth wrong...probably there isn't any USERS");
        }
        if (numberOfUsers > 0) {
            averageNumberOfCommentsPerUser = (double) numberOfComments / numberOfUsers;
        } else {
            System.out.println("Sth wrong...probably there isn't any USERS");
        }
        if (numberOfPosts > 0) {
            averageNumberOfCommentsPerPost = (double) numberOfComments / numberOfPosts;
        } else {
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

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }
}
