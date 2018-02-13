package com.example.graphqlservice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqlservice.model.Author;
import com.example.graphqlservice.model.Book;
import com.example.graphqlservice.repository.AuthorRepository;
import com.example.graphqlservice.repository.BookRepository;

/**
 * Created by scottmcallister on 2018-02-13.
 */
public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
