package com.clc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clc.dao.BookDao;
import com.clc.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	public BookDao dao;
	
	@Transactional
	public List<Book> allBooks() {
		return dao.allBooks();
	}
	
	@Transactional
	public Book bookById(long id) {
		return dao.bookById(id);
	}

	@Transactional
	public long saveBook(Book book) {
		
		return dao.saveBook(book);
		 
	}
	
	@Transactional
	public Book updateBook(long id,Book book) {
		return dao.updateBook(id,book);
	}

	public void deleteBook(long id) {

	}

}
