package com.book.onboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.onboard.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}