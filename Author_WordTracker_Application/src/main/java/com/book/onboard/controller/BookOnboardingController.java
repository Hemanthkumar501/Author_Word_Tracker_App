package com.book.onboard.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.book.onboard.Service.BookOnboardingService;
import com.book.onboard.Service.BookServiceException;
import com.book.onboard.dto.BookDTO;
import com.book.onboard.exceptionhandling.ResourceNotFoundException;
import com.book.onboard.model.Author;
import com.book.onboard.model.Book;

@RestController
public class BookOnboardingController {

	@Autowired
	private BookOnboardingService bookOnboardingService;

	@PostMapping("/book")
	public String addBook(@RequestBody Author author) {
		return bookOnboardingService.saveBook(author);
	}
	
	//Scenario-Book Returned "Success"
	@GetMapping("/book")
	public Object findAllBooks() throws ResourceNotFoundException, BookServiceException {
		try {
			Object AllbooksObj = bookOnboardingService.getAllBooks();
			if (AllbooksObj == null) {
				throw new ResourceNotFoundException("No Books found to Display");
			}
			return AllbooksObj;
		} catch (BookServiceException e) {
			throw new BookServiceException("Internal Server Exception while getting exception");
		}
	}
	
	//No Book <Found>.
	@GetMapping("/book1")
	public Object findAllBooks1() throws ResourceNotFoundException, BookServiceException {
		try {
			Object AllbooksObj = bookOnboardingService.getAllBooksNull();
			if (AllbooksObj == null) {
				throw new ResourceNotFoundException("No Books found");
			}
			return AllbooksObj;
		} catch (BookServiceException e) {
			throw new BookServiceException("Internal Server Exception while getting exception");
		}
	}

	//Error occurred.
	@GetMapping("/book2")
	public Object findAllBooks2() throws ResourceNotFoundException, BookServiceException {
		try {
			Object AllbooksObj = bookOnboardingService.getAllBooksException();
			if (AllbooksObj == null) {
				throw new ResourceNotFoundException("No Books found");
			}
			return AllbooksObj;
		} catch (BookServiceException e) {
			throw new BookServiceException("Internal Server Exception while getting exception");
		}
	}
	
	@GetMapping("/book/{id}")
	public List<BookDTO> findBookByBookId(@PathVariable int id) throws ResourceNotFoundException, BookServiceException {
		try {
			List<BookDTO> bookObject = bookOnboardingService.getBookByBookId(id);
			if (bookObject == null) {
				throw new ResourceNotFoundException("Book Id Not found");
			}
			return bookObject;
		} catch (Exception e) {
			throw new BookServiceException("Internal Server Exception while getting exception");
		}
	}
	
	@PutMapping("/book")
	public String updateBook(@RequestBody Book book) {
		return bookOnboardingService.updateBook(book);
		}


//	    @GetMapping("/getAllChapters/{id}")
//	    public  List<ChapterDTO> findAllChaptersByBookId(@PathVariable int id) throws Exception {
//	        return bookOnboardingService.getAllChaptersByBookId(id);
//	    }
	
	
	
}
