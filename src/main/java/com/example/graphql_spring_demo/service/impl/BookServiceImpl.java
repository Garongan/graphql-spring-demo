package com.example.graphql_spring_demo.service.impl;

import com.example.graphql_spring_demo.input.BookInput;
import com.example.graphql_spring_demo.entity.Author;
import com.example.graphql_spring_demo.entity.Book;
import com.example.graphql_spring_demo.repository.AuthorRepository;
import com.example.graphql_spring_demo.repository.BookRepository;
import com.example.graphql_spring_demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Book GetBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> GetAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book CreateBook(BookInput request) {
        Author existingAuthor = authorRepository.findByFirstNameAndLastName(request.firstName(), request.lastName());
        Author author = Author.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();
        if (existingAuthor != null) {
            author.setId(existingAuthor.getId());
        }
        Book book = Book.builder()
                .name(request.name())
                .pageCount(request.pageCount())
                .author(author)
                .build();
        return bookRepository.saveAndFlush(book);
    }
}
