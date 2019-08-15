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
		Session session = sessionfactory.openSession();
		return session.createQuery("from Book").getResultList();
	}

	public Book bookById(long id) {
		Session session = sessionfactory.openSession();
		return session.get(Book.class, id);
	}

	public long saveBook(Book book) {
		Session session = sessionfactory.openSession();
		return (Long) session.save(book);
	}

	public void updateBook(long id, Book book) {
		Session session = sessionfactory.openSession();

		Book oldbook = session.get(Book.class, id);
		oldbook.setTitle(book.getTitle());
		oldbook.setAuthor(book.getAuthor());
		session.update(oldbook);
		session.beginTransaction().commit();
		session.close();

	}

	public void deleteBook(long id) {
		Session session = sessionfactory.openSession();
		
		Book book = session.get(Book.class, id);
		session.delete(book);
		session.beginTransaction().commit();
		session.close();

	}

}
