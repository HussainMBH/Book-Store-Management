package com.example.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
