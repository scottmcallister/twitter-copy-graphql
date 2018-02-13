package com.example.graphqlservice.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlservice.model.Author;
import com.example.graphqlservice.model.Book;
import com.example.graphqlservice.repository.AuthorRepository;
import com.example.graphqlservice.repository.BookRepository;

/**
 * Created by scottmcallister on 2018-02-13.
 */
public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) throws Exception {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            throw new Exception("book with id " + id + " was not found");
        }

        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
}
