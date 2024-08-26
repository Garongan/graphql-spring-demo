package com.example.graphql_spring_demo.service;

import com.example.graphql_spring_demo.input.BookInput;
import com.example.graphql_spring_demo.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book GetBookById(String id);
    List<Book> GetAllBooks();
    Book CreateBook(BookInput request);
}
