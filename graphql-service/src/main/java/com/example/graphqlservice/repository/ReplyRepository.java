package com.example.graphqlservice.repository;

import com.example.graphqlservice.model.Reply;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by scottmcallister on 2018-02-16.
 */
public interface ReplyRepository extends CrudRepository<Reply, Long> {
}
