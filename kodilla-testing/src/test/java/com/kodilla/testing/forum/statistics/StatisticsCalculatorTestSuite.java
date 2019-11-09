package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class StatisticsCalculatorTestSuite {
    private static int testNumber = 0;

    @Before
    public void before() {
        testNumber++;
        System.out.println("Test number: " + testNumber);
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testCalculateAdvStatisticsZeroPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> listOfUsers = new ArrayList<>();
        listOfUsers.add("Vertar");
        listOfUsers.add("Vertar");


        int numberOfPosts = 0;
        int numberOfComments = 6;

        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        int resultOfNumberOfUsers = statisticsCalculator.getNumberOfUsers();
        int resultOfNumberOfPosts = statisticsCalculator.getNumberOfPosts();
        int resultOfNumberOfComments = statisticsCalculator.getNumberOfComments();
        double resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        double resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        double resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(2, resultOfNumberOfUsers);
        Assert.assertEquals(0, resultOfNumberOfPosts);
        Assert.assertEquals(6, resultOfNumberOfComments);
        Assert.assertEquals(0.0, resultOfAverageNumberOfPostsPerUser,0);
        Assert.assertEquals(3, resultOfAverageNumberOfCommentsPerUser,0);
        Assert.assertEquals(0, resultOfAverageNumberOfCommentsPerPost,0);
    }

    @Test
    public void testCalculateAdvStatistics1000Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> listOfUsers = new ArrayList<>();
        listOfUsers.add("Vertar");
        listOfUsers.add("Vertar");

        int numberOfPosts = 1000;
        int numberOfComments = 10;

        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        int resultOfNumberOfUsers = statisticsCalculator.getNumberOfUsers();
        int resultOfNumberOfPosts = statisticsCalculator.getNumberOfPosts();
        int resultOfNumberOfComments = statisticsCalculator.getNumberOfComments();
        double resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        double resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        double resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(2, resultOfNumberOfUsers);
        Assert.assertEquals(1000, resultOfNumberOfPosts);
        Assert.assertEquals(10, resultOfNumberOfComments);
        Assert.assertEquals(500, resultOfAverageNumberOfPostsPerUser,0);
        Assert.assertEquals(5, resultOfAverageNumberOfCommentsPerUser,0);
        Assert.assertEquals(0.01, resultOfAverageNumberOfCommentsPerPost,0);

    }

    @Test
    public void testCalculateAdvStatisticsZeroComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> listOfUsers = new ArrayList<>();
        listOfUsers.add("Vertar");
        listOfUsers.add("Vertar");

        int numberOfPosts = 100;
        int numberOfComments = 0;

        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);


        //When
        int resultOfNumberOfUsers = statisticsCalculator.getNumberOfUsers();
        int resultOfNumberOfPosts = statisticsCalculator.getNumberOfPosts();
        int resultOfNumberOfComments = statisticsCalculator.getNumberOfComments();
        double resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        double resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        double resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(2, resultOfNumberOfUsers);
        Assert.assertEquals(100, resultOfNumberOfPosts);
        Assert.assertEquals(0, resultOfNumberOfComments);
        Assert.assertEquals(50, resultOfAverageNumberOfPostsPerUser,0);
        Assert.assertEquals(0.0, resultOfAverageNumberOfCommentsPerUser,0);
        Assert.assertEquals(0.0, resultOfAverageNumberOfCommentsPerPost,0);


    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> listOfUsers = new ArrayList<>();
        listOfUsers.add("Vertar");
        listOfUsers.add("Vertar");

        int numberOfPosts = 50;
        int numberOfComments = 100;

        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        int resultOfNumberOfUsers = statisticsCalculator.getNumberOfUsers();
        int resultOfNumberOfPosts = statisticsCalculator.getNumberOfPosts();
        int resultOfNumberOfComments = statisticsCalculator.getNumberOfComments();
        double resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        double resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        double resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(2, resultOfNumberOfUsers);
        Assert.assertEquals(50, resultOfNumberOfPosts);
        Assert.assertEquals(100, resultOfNumberOfComments);
        Assert.assertEquals(25, resultOfAverageNumberOfPostsPerUser,0);
        Assert.assertEquals(50, resultOfAverageNumberOfCommentsPerUser,0);
        Assert.assertEquals(2, resultOfAverageNumberOfCommentsPerPost,0);
    }

    @Test
    public void testCalculateAdvStatisticsMorePostsThanComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> listOfUsers = new ArrayList<>();
        listOfUsers.add("Vertar");
        listOfUsers.add("Vertar");


        int numberOfPosts = 120;
        int numberOfComments = 60;

        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        int resultOfNumberOfUsers = statisticsCalculator.getNumberOfUsers();
        int resultOfNumberOfPosts = statisticsCalculator.getNumberOfPosts();
        int resultOfNumberOfComments = statisticsCalculator.getNumberOfComments();
        double resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        double resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        double resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(2, resultOfNumberOfUsers);
        Assert.assertEquals(120, resultOfNumberOfPosts);
        Assert.assertEquals(60, resultOfNumberOfComments);
        Assert.assertEquals(60, resultOfAverageNumberOfPostsPerUser,0);
        Assert.assertEquals(30, resultOfAverageNumberOfCommentsPerUser,0);
        Assert.assertEquals(0.5, resultOfAverageNumberOfCommentsPerPost,0);
    }

    @Test
    public void testCalculateAdvStatisticsZeroUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> listOfUsers = new ArrayList<>();

        int numberOfPosts = 100;
        int numberOfComments = 25;

        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        int resultOfNumberOfUsers = statisticsCalculator.getNumberOfUsers();
        int resultOfNumberOfPosts = statisticsCalculator.getNumberOfPosts();
        int resultOfNumberOfComments = statisticsCalculator.getNumberOfComments();
        double resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        double resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        double resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(0, resultOfNumberOfUsers);
        Assert.assertEquals(100, resultOfNumberOfPosts);
        Assert.assertEquals(25, resultOfNumberOfComments);
        Assert.assertEquals(0, resultOfAverageNumberOfPostsPerUser,0);
        Assert.assertEquals(0, resultOfAverageNumberOfCommentsPerUser,0);
        Assert.assertEquals(0.25, resultOfAverageNumberOfCommentsPerPost,0);
    }

    @Test
    public void testCalculateAdvStatistics100Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        String[] array = {
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"
        };

        List<String> listOfUsers = Arrays.asList(array);


        int numberOfPosts = 25;
        int numberOfComments = 50;

        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        int resultOfNumberOfUsers = statisticsCalculator.getNumberOfUsers();
        int resultOfNumberOfPosts = statisticsCalculator.getNumberOfPosts();
        int resultOfNumberOfComments = statisticsCalculator.getNumberOfComments();
        double resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        double resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        double resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(100, resultOfNumberOfUsers);
        Assert.assertEquals(25, resultOfNumberOfPosts);
        Assert.assertEquals(50, resultOfNumberOfComments);
        Assert.assertEquals(0.25, resultOfAverageNumberOfPostsPerUser,0);
        Assert.assertEquals(0.50, resultOfAverageNumberOfCommentsPerUser,0);
        Assert.assertEquals(2.0, resultOfAverageNumberOfCommentsPerPost,0);
    }
}
