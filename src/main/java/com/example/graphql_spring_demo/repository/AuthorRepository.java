package com.example.graphql_spring_demo.repository;

import com.example.graphql_spring_demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {
    Author findByFirstNameAndLastName(String firstName, String lastName);
}
