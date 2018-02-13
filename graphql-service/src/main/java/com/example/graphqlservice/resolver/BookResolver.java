package com.example.graphqlservice.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphqlservice.model.Author;
import com.example.graphqlservice.model.Book;
import com.example.graphqlservice.repository.AuthorRepository;

/**
 * Created by scottmcallister on 2018-02-12.
 */
public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }
}
