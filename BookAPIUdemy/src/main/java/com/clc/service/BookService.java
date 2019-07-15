package com.clc.service;

import java.util.List;

import com.clc.model.Book;

public interface BookService {

	
	List<Book> allBooks();
	
	Book bookById(long id);
	
	long saveBook(Book book);
	
	Book updateBook(long id,Book book);
	
	void deleteBook(long id);
	
}
