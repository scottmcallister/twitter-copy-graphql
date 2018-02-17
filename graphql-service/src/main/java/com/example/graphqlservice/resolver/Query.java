package com.example.graphqlservice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqlservice.model.Tweet;
import com.example.graphqlservice.model.User;
import com.example.graphqlservice.repository.TweetRepository;
import com.example.graphqlservice.repository.UserRepository;

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

    public Iterable<User> findAllUsers() { return userRepository.findAll(); }

    public Iterable<Tweet> findAllTweets() { return tweetRepository.findAll(); }

    public long countUsers() { return userRepository.count(); }

    public long countTweets() { return tweetRepository.count(); }
}
