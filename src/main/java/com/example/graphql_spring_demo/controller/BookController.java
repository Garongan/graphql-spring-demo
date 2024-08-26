package com.example.graphql_spring_demo.controller;

import com.example.graphql_spring_demo.entity.Book;
import com.example.graphql_spring_demo.input.BookInput;
import com.example.graphql_spring_demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @QueryMapping
    public Book getBookById(@Argument String id) {
        log.info("id: {}", id);
        return bookService.GetBookById(id);
    }

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookService.GetAllBooks();
    }

    @MutationMapping
    public Book createBook(@Argument(name = "book") BookInput bookInput) {
        log.info("bookInput: {}", bookInput);
        return bookService.CreateBook(bookInput);
    }
}
