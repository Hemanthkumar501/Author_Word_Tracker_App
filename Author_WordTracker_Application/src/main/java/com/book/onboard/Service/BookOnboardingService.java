package com.book.onboard.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.onboard.dto.BookDTO;
import com.book.onboard.dto.ChapterDTO;
import com.book.onboard.dto.RecordDTO;
import com.book.onboard.model.Author;
import com.book.onboard.model.Book;
import com.book.onboard.model.BookChapter;
import com.book.onboard.model.BookRecord;
import com.book.onboard.repository.BookRepository;
import com.book.onboard.repository.BookonboardingRepository;
import com.book.onboard.repository.ChaptersRepository;
import com.book.onboard.repository.RecordsRepository;

@Service
public class BookOnboardingService {

	@Autowired
	private BookonboardingRepository bookonboardingRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ChaptersRepository chaptersRepository;

	@Autowired
	private RecordsRepository recordsRepository;
	
	@Autowired
	private BookDetailsFactory bookDetailsFactory;
	

	private Book book;

	private BookChapter bookChapter;
	
	private BookRecord bookRecord;
	
	// GET- All the BOOKS. Returns Book Object.
	public Object getAllBooks() throws BookServiceException {
		List<Book> booksObj = bookRepository.findAll();
		return booksObj.stream().map(this::convertBookEntity).collect(Collectors.toList());
	}

	//GET-Book by Book ID
	public  List<BookDTO> getBookByBookId(int id) throws BookServiceException {
		Optional<Book> booksObj = bookRepository.findById(id);
		return booksObj.stream().map(this::convertBookEntity).collect(Collectors.toList());
	}
	//Return(s) BOOK as "<NULL>" value.
	public Object getAllBooksNull() throws BookServiceException {
		return null;
	}

	//Throws Exception BookServiceException.
	public Object getAllBooksException() throws BookServiceException {
		throw new BookServiceException();
	}

	// Find All chapters By BOOK ID.
//	public List<ChapterDTO>  getAllChaptersByBookId(int id){
//		//Optional<Book> bookObj = bookRepository.findById(id);
//		List<BookChapter> chapterObj = chaptersRepository.findAll();
//		return  chapterObj.stream().map(this::convertChapterEntity).collect(Collectors.toList());
//	}


	// Convert BOOK Entity To DTO.
	private BookDTO convertBookEntity(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setName(book.getName());
		bookDTO.setBookId(book.getId());
		return bookDTO;
	}

	// Convert Chapter Entity to DTO.
	private ChapterDTO convertChapterEntity(BookChapter bookChapter) {
		ChapterDTO chapterDTO = new ChapterDTO();
		chapterDTO.setChaptername(bookChapter.getName());
		chapterDTO.setChapterId(bookChapter.getId());
		return chapterDTO;
	}

	// Convert Record Entity To DTO.
	private RecordDTO convertRecordEntity(BookRecord bookRecord) {
		RecordDTO recordDTO = new RecordDTO();
		recordDTO.setRecordId(bookRecord.getId());
		recordDTO.setWordCount(bookRecord.getWordCount());
		return recordDTO;
	}

	public String saveBook(Author author) {
		Book book = author.getBook();
		book.setAuthor(author);
		// author.setId(author.getId());
		for (BookChapter chapter : book.getChapters()) {
			chapter.setBook(book);
			for (BookRecord record : chapter.getRecords()) {
				record.setChapter(chapter);
			}
		}
		bookonboardingRepository.save(author);
		return "Book created successfully! ";
	}

	//PUT-updateBook.
	public String updateBook(Book book) {
		//List<BookChapter> bookChapter=book.getChapters();
		if (bookRepository.findById(book.getId()).isPresent()) {
			for (BookChapter chapter : book.getChapters()) {
				if (chaptersRepository.findById(chapter.getId()).isPresent()) {
					for (BookRecord record : chapter.getRecords()) {
						record.setChapter(chapter);
					}
				}
			}
			bookRepository.save(book);
			return "Book updated successfully! ";
		} else {
			for (BookChapter chapter : book.getChapters()) {
				chapter.setBook(book);
				for (BookRecord record : chapter.getRecords()) {
					record.setChapter(chapter);
				}
			}
		}
		bookRepository.save(book);
		return "Book created successfully! ";
	}
}