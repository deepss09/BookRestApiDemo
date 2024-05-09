package com.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.dao.BookRepository;
import com.jpa.entities.Books;

@Component
public class BookService {
    @Autowired
	private BookRepository bookRepository;
//	private static List<Books> list = new ArrayList<>();

//	static 
//	{
//		list.add(new Books(12,"Java book","aaa"));
//		list.add(new Books(145,"Java book","acca"));
//		list.add(new Books(12456,"Java book","aaddda"));
//		
//		
//	}
	//get all books
	public List<Books> getAllBooks(){
		List<Books> list = (List<Books>)this.bookRepository.findAll();
		return list;
	}
	//get single book by id
	public Books getBookById(int id) {
		Books book = null;
		book = this.bookRepository.findById(id);
//		book = list.stream().
//				filter(e -> e.getId() == id)
//                .findFirst().get();
		return book;
	}
	public Books addBook(Books b) {
		Books result = bookRepository.save(b);
		return result;
	}
	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);
//		list = list.stream().filter(book->{
//			if(book.getId()!=bid)
//			{
//				return true;
//			}
//			else {
//				return false;
//			}
//		}).collect(Collectors.toList());
	}
	public void updateBook(Books book, int bookId) {
		book.setId(bookId);
		bookRepository.save(book);
//		list.stream().map(b->{
//			if(b.getId() == bookId)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
	}
}
