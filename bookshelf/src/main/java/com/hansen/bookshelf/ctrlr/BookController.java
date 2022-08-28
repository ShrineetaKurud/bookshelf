package com.hansen.bookshelf.ctrlr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hansen.bookshelf.model.Book;
import com.hansen.bookshelf.srvc.BookSrvc;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookSrvc bookSrvc;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Book bookToBeCreated) {
		ResponseEntity<String> bookResponse;
		
		
		boolean book = bookSrvc.createBook(bookToBeCreated);
	
		if(book) {
			bookResponse = new ResponseEntity<>("Added Sucessfully !!", null, HttpStatus.CREATED);
			
		}else {
			bookResponse = new ResponseEntity<>("ID Already Exists !!", null, HttpStatus.NOT_FOUND);
			
		}
		
		return bookResponse;
	}

	@RequestMapping(value = "{bookId}", method = RequestMethod.GET)
	public ResponseEntity<Book> read(@PathVariable(value = "bookId") Integer bookId) {
		ResponseEntity<Book> bookResponse;
		
		
		Book book = bookSrvc.getBook(bookId);
		
		if(book!=null) {
			bookResponse = new ResponseEntity<Book>(book, null, HttpStatus.OK);
			
		}else {
			bookResponse = new ResponseEntity<Book>(book, null, HttpStatus.NOT_FOUND);
			
		}
	
		return bookResponse;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Book>> readAll() {
		ResponseEntity<List<Book>> bookResponse;
		
		
		List<Book> bookList = bookSrvc.getAllBooks();
		
		
		bookResponse = new ResponseEntity<List<Book>>(bookList, null, HttpStatus.OK);
		return bookResponse;
	}

	@RequestMapping(method = RequestMethod.PATCH) //OR PUT
	public ResponseEntity<String> update(@RequestBody Book bookToBeUpdated) {
		ResponseEntity<String> bookResponse;
		
		
		boolean book = bookSrvc.updateBook(bookToBeUpdated);
		
		if(book) {
			bookResponse = new ResponseEntity<>("Updated Sucessfully !!", null, HttpStatus.CREATED);
		}else {
			bookResponse = new ResponseEntity<>("ID Not Found !!", null, HttpStatus.NOT_FOUND);
		}
		
		return bookResponse;
	}

	@RequestMapping(value = "{bookId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable(value = "bookId") Integer bookId) {
		ResponseEntity<String> bookResponse;
		
		
		boolean isdeleted = bookSrvc.deleteBook(bookId);
		
		if (isdeleted) {
			bookResponse = new ResponseEntity<>("Deleted Sucessfully !!", null, HttpStatus.OK);
		} else {
			bookResponse = new ResponseEntity<>("ID Not Found !!", null, HttpStatus.NOT_FOUND);
		}
		return bookResponse;
	}

}
