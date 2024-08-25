package com.example.graphql_spring_demo.entity;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "page_count", nullable = false)
    private Integer pageCount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
