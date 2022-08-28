package com.hansen.bookshelf.srvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hansen.bookshelf.model.Book;

@Service
public class BookSrvc {

	private static HashMap<Integer, Book> bookMap = new HashMap<Integer, Book>();

	public boolean createBook(Book bookToBeCreated) {
		
		boolean ans = bookMap.containsKey(bookToBeCreated.getId());
		
		if(ans) {
			return false;
		}else {
			bookMap.put(bookToBeCreated.getId(), bookToBeCreated);
			return true;	
		}
		
	}

	public Book getBook(Integer bookId) {
		return bookMap.get(bookId);
	}

	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<Book>(bookMap.values());
		return bookList; 
	}

	public boolean updateBook(Book bookToBeUpdated) {
		
		
		boolean ans = bookMap.containsKey(bookToBeUpdated.getId());
		
		if(ans) {
			bookMap.put(bookToBeUpdated.getId(), bookToBeUpdated);
			return true;
		}else {
			return false;
		}
	}

	public boolean deleteBook(Integer bookId) {

		//TODO Homework: Write code to delete bookId from bookMap(hashmap)
		
		if(bookMap.containsKey(bookId)){
			bookMap.remove(bookId);
			return true;
		}
		else {
			return false;	
		}
	//	return !bookMap.containsKey(bookId);
	}

}