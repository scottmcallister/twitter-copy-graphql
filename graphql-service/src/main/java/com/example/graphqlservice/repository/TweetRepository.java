package com.example.graphqlservice.repository;

import com.example.graphqlservice.model.Tweet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by scottmcallister on 2018-02-16.
 */
public interface TweetRepository extends CrudRepository<Tweet, Long> {
}
