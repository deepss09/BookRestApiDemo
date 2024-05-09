package com.jpa.controllers;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entities.Books;
import com.jpa.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
//	@RequestMapping(value = "/books", method = RequestMethod.GET )
//	@ResponseBody
	@GetMapping("/books")
	public ResponseEntity<List<Books>>getBooks() {
		List<Books> list = bookService.getAllBooks();
		if(list.size()<=0){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));

	}
		@GetMapping("/books/{id}")
		public Books getBook(@PathVariable("id") int id)
		{
			return bookService.getBookById(id);
		}
		
		@PostMapping("/books")
		public Books addBook(@RequestBody Books book) {
			Books b = this.bookService.addBook(book);
			return b;
			
		}
		@DeleteMapping("/books/{bookId}")
		public void deleteBook(@PathVariable("bookId") int bookId) {
			this.bookService.deleteBook(bookId);
		}
		@PutMapping("/books/{bookId}")
		public Books updateBook(@RequestBody Books book,@PathVariable("bookId") int bookId)
		{
			this.bookService.updateBook(book,bookId);
		     return book;
		}
	}

