package com.book.onboard.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.onboard.model.BookRecord;

@Repository
public interface RecordsRepository extends JpaRepository<BookRecord, Integer> {
	
}