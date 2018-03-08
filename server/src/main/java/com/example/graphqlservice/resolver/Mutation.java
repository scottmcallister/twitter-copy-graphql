package com.example.graphqlservice.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlservice.model.Tweet;
import com.example.graphqlservice.model.User;
import com.example.graphqlservice.repository.*;

import java.util.Date;

/**
 * Created by scottmcallister on 2018-02-13.
 */
public class Mutation implements GraphQLMutationResolver {
    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    public Mutation(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public Tweet newTweet(Long authorId, String text) {
        User author = userRepository.findOne(authorId);
        Tweet tweet = new Tweet();
        tweet.setAuthor(author);
        tweet.setText(text);
        tweet.setLikes(0);
        tweet.setTimestamp(new Date().getTime());
        tweetRepository.save(tweet);

        return tweet;
    }

    public boolean deleteTweet(Long id) {
        tweetRepository.delete(id);
        return true;
    }

    public Tweet updateTweetLikes(Integer likes, Long id) {
        Tweet tweet = tweetRepository.findOne(id);
        tweet.setLikes(likes);
        tweetRepository.save(tweet);
        return tweet;
    }

    public User newUser(String name, String handle,
                        String email, String password) {
        User user = new User();
        user.setName(name);
        user.setHandle(handle);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }
}
