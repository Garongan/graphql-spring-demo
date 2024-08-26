package com.example.graphql_spring_demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "page_count", nullable = false)
    private Integer pageCount;
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.PERSIST)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
