package com.book.onboard.Service;
import org.springframework.stereotype.Service;
import com.book.onboard.dto.BookAllDetailsDTO;
import com.book.onboard.model.Book;
import com.book.onboard.model.BookChapter;
import com.book.onboard.model.BookRecord;

@Service
public class BookDetailsFactory {

	public BookAllDetailsDTO CreateBookAllDetails(Book book, BookChapter bookChapter, BookRecord bookRecord) {

		return new BookAllDetailsDTO(book.getId(), book.getName(), book.getDatetimestamp(), bookChapter.getId(),
				bookChapter.getName(), bookChapter.getDatetimestamp(), bookRecord.getId(), bookRecord.getDatetimestamp(),
				bookRecord.getWordCount());
	}
}