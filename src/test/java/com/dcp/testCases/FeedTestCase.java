package com.dcp.testCases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dcp.entity.Feed;
import com.dcp.exception.FeedNotFoundException;
import com.dcp.repository.FeedRepository;
import com.dcp.serviceImpl.FeedService;



@SpringBootTest
class FeedTestCase {

    @Autowired
    private FeedService feedService;

    @MockBean
    private FeedRepository feedRepository;

    @InjectMocks
    FeedService feedservice = new FeedService();
    static Feed feed = new Feed();

    static List<Feed> feedList;
    static List<Feed> feedList1;

    @BeforeAll
    public static void setUp() {

        feedList = new ArrayList<>();
        feedList1 = new ArrayList<>();

        feed.setFeedId(1);
        feed.setQuery("What is Sql?");
        feed.setTopic("sql");
        feed.setRelevance(9);
        feed.setTotalComments(20);
        feedList.add(feed);

    }

    @Test
    public void testAddFeed() {

        Mockito.when(feedRepository.saveAndFlush(feed)).thenReturn(feed);
        assertNotNull(feedService.addFeed(feed));
    }

    @Test
    void testGetFeed() throws FeedNotFoundException {
        Mockito.when(feedRepository.findAll()).thenReturn(feedList);
    }

    

}