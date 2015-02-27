/**
 * 
 */
package org.quicky.service;

import java.util.List;

import org.quicky.dao.BookDao;
import org.quicky.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Emmanuel
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public void addBook(Book book) {
		bookDao.create(book);
	}

	@Override
	public void deleteBook(Book book) {
		bookDao.delete(book);
	}
}
