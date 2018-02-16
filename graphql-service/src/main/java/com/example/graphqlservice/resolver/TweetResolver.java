package com.example.graphqlservice.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphqlservice.model.Tweet;
import com.example.graphqlservice.model.User;
import com.example.graphqlservice.repository.TweetRepository;
import com.example.graphqlservice.repository.UserRepository;

/**
 * Created by scottmcallister on 2018-02-16.
 */
public class TweetResolver implements GraphQLResolver<Tweet>{
    private UserRepository userRepository;
    private TweetRepository tweetRepository;

    private TweetResolver(UserRepository userRepository,
                          TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public User getAuthor(Tweet tweet) { return userRepository.findOne(tweet.getAuthor().getId()); }
    public Tweet getParent(Tweet tweet) {  return tweetRepository.findOne(tweet.getParent().getId()); }
}
