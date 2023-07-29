package com.example.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.Entity.MyBookList;
@Repository
public interface mybookRepository extends JpaRepository<MyBookList,Integer> {

}
