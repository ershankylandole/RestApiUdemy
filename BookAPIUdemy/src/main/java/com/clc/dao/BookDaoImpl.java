package com.clc.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clc.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	public SessionFactory sessionfactory;
	
	
	public List<Book> allBooks() {
		Session session  = sessionfactory.openSession();
		return session.createQuery("from Book").getResultList();
	}

	public Book bookById(long id) {
		Session session  = sessionfactory.openSession();
		return session.get(Book.class, id);
	}

	public long saveBook(Book book) {
		Session session  = sessionfactory.openSession();
		return (Long) session.save(book);
	}

	public Book updateBook(long id,Book book) {
		Session session  = sessionfactory.openSession();
		//book = session.get(Book.class, id);
		
		Book oldBook = session.get(Book.class, id);
		oldBook.setTitle(book.getTitle());
		oldBook.setAuthor(book.getAuthor());
		
		//book.setTitle(book.getTitle());
		//book.setAuthor(book.getAuthor());
		return oldBook;
		
	}

	public void deleteBook(long id) {

	}

}
