package com.hansen.bookshelf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hansen.bookshelf.model.Book;
import com.hansen.bookshelf.srvc.BookSrvc;

@SpringBootApplication
public class BookshelfApplication {

	@Bean
	CommandLineRunner init(BookSrvc bookSrvc) {
		
		return (evt) -> {
		Book demoBook = new Book();
		demoBook.setId(1);
		demoBook.setName("Hansen CSD Book");
		demoBook.setAuthor("Satyen Pandhare");
		bookSrvc.createBook(demoBook);
		};
		
		
	}

	
	public static void main(String[] args) {
		SpringApplication.run(BookshelfApplication.class, args);
	}

}
