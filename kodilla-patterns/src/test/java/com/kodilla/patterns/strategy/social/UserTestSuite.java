package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User user1 = new Millenials("Roman");
        User user2 = new YGeneration("Martin");
        User user3 = new ZGeneration("John");
        //When
        String user1Publisher = user1.sharePost();
        String user2Publisher = user2.sharePost();
        String user3Publisher = user3.sharePost();
        //Then
        Assert.assertEquals("Facebook post...", user1Publisher);
        Assert.assertEquals("Twitter post...", user2Publisher);
        Assert.assertEquals("Snapchat post...", user3Publisher);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User user1 = new Millenials("Roman");
        User user2 = new YGeneration("Martin");
        User user3 = new ZGeneration("John");
        //When
        user1.setSocialPublisher(new TwitterPublisher());
        user2.setSocialPublisher(new SnapchatPublisher());
        user3.setSocialPublisher(new FacebookPublisher());
        String user1Publisher = user1.sharePost();
        String user2Publisher = user2.sharePost();
        String user3Publisher = user3.sharePost();
        //Then
        Assert.assertEquals("Twitter post...", user1Publisher);
        Assert.assertEquals("Snapchat post...", user2Publisher);
        Assert.assertEquals("Facebook post...", user3Publisher);
    }
}
