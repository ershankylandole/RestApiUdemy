package com.clc.dao;

import java.util.List;

import com.clc.model.Book;

public interface BookDao {
	
	List<Book> allBooks();
	
	Book bookById(long id);
	
	long saveBook(Book book);
	
	void updateBook(long id , Book book);
	
	void deleteBook(long id);
	
	

}
