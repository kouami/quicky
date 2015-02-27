/**
 * 
 */
package org.quicky.service;

import java.util.List;

import org.quicky.model.Book;

/**
 * @author Emmanuel
 *
 */
public interface BookService {
	
	public List<Book> getAllBooks();
	public void addBook(Book book);
	public void deleteBook(Book book);
}
