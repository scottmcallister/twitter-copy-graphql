package com.example.graphqlservice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqlservice.model.Tweet;
import com.example.graphqlservice.model.User;
import com.example.graphqlservice.repository.TweetRepository;
import com.example.graphqlservice.repository.UserRepository;

import java.util.ArrayList;

/**
 * Created by scottmcallister on 2018-02-13.
 */
public class Query implements GraphQLQueryResolver {
    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    public Query(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public Iterable<User> allUsers() { return userRepository.findAll(); }

    public Iterable<Tweet> allTweets() { return tweetRepository.findAll(); }

    public User user(Long id) { return userRepository.findOne(id); }

    public Tweet tweet(Long id) { return tweetRepository.findOne(id); }

    public long countUsers() { return userRepository.count(); }

    public long countTweets() { return tweetRepository.count(); }
}
