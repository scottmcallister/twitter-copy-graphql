package com.example.graphqlservice.repository;

import com.example.graphqlservice.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by scottmcallister on 2018-02-12.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
