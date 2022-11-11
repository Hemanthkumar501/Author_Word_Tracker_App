package com.book.onboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.onboard.model.Author;

@Repository
public interface BookonboardingRepository extends JpaRepository<Author, Integer> {

}