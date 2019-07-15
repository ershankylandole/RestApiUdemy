package com.clc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clc.model.Book;
import com.clc.service.BookService;

@RestController
@RequestMapping(value="/book")
public class BookController {
	
	@Autowired
	public BookService service;
	
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public List<Book> getAllBooks(){
		return service.allBooks();
		
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public Book getSingleBook(@PathVariable("id") long id) {
		return service.bookById(id);
	}
	
	@RequestMapping(value="/" , method = RequestMethod.POST)
	public String saveBook(@RequestBody Book book) {
		 service.saveBook(book);
		 return "Book Successfully added ";
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.PUT)
	public Book update(@PathVariable long id , @RequestBody Book book) {
		
		/*
		 * Book oldBook = getSingleBook(id); oldBook.setTitle(book.getTitle());
		 * oldBook.setAuthor(book.getAuthor());
		 */
		return service.updateBook(id,book);
		 
	}
	

}
