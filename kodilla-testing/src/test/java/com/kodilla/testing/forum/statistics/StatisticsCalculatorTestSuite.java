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
        listOfUsers.add("Vertar");

        int numberOfPosts = 0;
        int numberOfComments = 1;

        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        int resultOfNumberOfUsers = statisticsCalculator.getNumberOfUsers();
        int resultOfNumberOfPosts = statisticsCalculator.getNumberOfPosts();
        int resultOfNumberOfComments = statisticsCalculator.getNumberOfComments();
        Object resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        Object resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        Object resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(3, resultOfNumberOfUsers);
        Assert.assertEquals(0, resultOfNumberOfPosts);
        Assert.assertEquals(1, resultOfNumberOfComments);
        Assert.assertEquals(0.0 / 3, resultOfAverageNumberOfPostsPerUser);
        Assert.assertEquals(1.0 / 3, resultOfAverageNumberOfCommentsPerUser);
        Assert.assertEquals(false, resultOfAverageNumberOfCommentsPerPost);
    }

    @Test
    public void testCalculateAdvStatistics1000Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> listOfUsers = new ArrayList<>();
        listOfUsers.add("Vertar");
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
        Object resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        Object resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        Object resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(3, resultOfNumberOfUsers);
        Assert.assertEquals(1000, resultOfNumberOfPosts);
        Assert.assertEquals(10, resultOfNumberOfComments);
        Assert.assertEquals(1000.0 / 3, resultOfAverageNumberOfPostsPerUser);
        Assert.assertEquals(10.0 / 3, resultOfAverageNumberOfCommentsPerUser);
        Assert.assertEquals(10.0 / 1000, resultOfAverageNumberOfCommentsPerPost);

    }

    @Test
    public void testCalculateAdvStatisticsZeroComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> listOfUsers = new ArrayList<>();
        listOfUsers.add("Vertar");
        listOfUsers.add("Vertar");
        listOfUsers.add("Vertar");

        int numberOfPosts = 99;
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
        Object resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        Object resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        Object resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(3, resultOfNumberOfUsers);
        Assert.assertEquals(99, resultOfNumberOfPosts);
        Assert.assertEquals(0, resultOfNumberOfComments);
        Assert.assertEquals(33.0, resultOfAverageNumberOfPostsPerUser);
        Assert.assertEquals(0.0, resultOfAverageNumberOfCommentsPerUser);
        Assert.assertEquals(0.0, resultOfAverageNumberOfCommentsPerPost);


    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> listOfUsers = new ArrayList<>();
        listOfUsers.add("Vertar");
        listOfUsers.add("Vertar");
        listOfUsers.add("Vertar");

        int numberOfPosts = 33;
        int numberOfComments = 999;

        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        int resultOfNumberOfUsers = statisticsCalculator.getNumberOfUsers();
        int resultOfNumberOfPosts = statisticsCalculator.getNumberOfPosts();
        int resultOfNumberOfComments = statisticsCalculator.getNumberOfComments();
        Object resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        Object resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        Object resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(3, resultOfNumberOfUsers);
        Assert.assertEquals(33, resultOfNumberOfPosts);
        Assert.assertEquals(999, resultOfNumberOfComments);
        Assert.assertEquals(33.0 / 3, resultOfAverageNumberOfPostsPerUser);
        Assert.assertEquals(333.0, resultOfAverageNumberOfCommentsPerUser);
        Assert.assertEquals(999.0 / 33, resultOfAverageNumberOfCommentsPerPost);
    }

    @Test
    public void testCalculateAdvStatisticsMorePostsThanComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> listOfUsers = new ArrayList<>();
        listOfUsers.add("Vertar");
        listOfUsers.add("Vertar");
        listOfUsers.add("Vertar");

        int numberOfPosts = 121;
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
        Object resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        Object resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        Object resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(3, resultOfNumberOfUsers);
        Assert.assertEquals(121, resultOfNumberOfPosts);
        Assert.assertEquals(25, resultOfNumberOfComments);
        Assert.assertEquals(121.0 / 3, resultOfAverageNumberOfPostsPerUser);
        Assert.assertEquals(25.0 / 3, resultOfAverageNumberOfCommentsPerUser);
        Assert.assertEquals(25.0 / 121, resultOfAverageNumberOfCommentsPerPost);
    }

    @Test
    public void testCalculateAdvStatisticsZeroUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> listOfUsers = new ArrayList<>();

        int numberOfPosts = 92;
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
        Object resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        Object resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        Object resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(0, resultOfNumberOfUsers);
        Assert.assertEquals(92, resultOfNumberOfPosts);
        Assert.assertEquals(25, resultOfNumberOfComments);
        Assert.assertEquals(false, resultOfAverageNumberOfPostsPerUser);
        Assert.assertEquals(false, resultOfAverageNumberOfCommentsPerUser);
        Assert.assertEquals(25.0 / 92, resultOfAverageNumberOfCommentsPerPost);
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
        int numberOfComments = 42;

        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        int resultOfNumberOfUsers = statisticsCalculator.getNumberOfUsers();
        int resultOfNumberOfPosts = statisticsCalculator.getNumberOfPosts();
        int resultOfNumberOfComments = statisticsCalculator.getNumberOfComments();
        Object resultOfAverageNumberOfPostsPerUser = statisticsCalculator.getAverageNumberOfPostsPerUser();
        Object resultOfAverageNumberOfCommentsPerUser = statisticsCalculator.getAverageNumberOfCommentsPerUser();
        Object resultOfAverageNumberOfCommentsPerPost = statisticsCalculator.getAverageNumberOfCommentsPerPost();

        //Then
        Assert.assertEquals(100, resultOfNumberOfUsers);
        Assert.assertEquals(25, resultOfNumberOfPosts);
        Assert.assertEquals(42, resultOfNumberOfComments);
        Assert.assertEquals(0.25, resultOfAverageNumberOfPostsPerUser);
        Assert.assertEquals(0.42, resultOfAverageNumberOfCommentsPerUser);
        Assert.assertEquals(42.0 / 25, resultOfAverageNumberOfCommentsPerPost);
    }
}
