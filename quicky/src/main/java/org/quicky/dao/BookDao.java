/**
 * 
 */
package org.quicky.dao;

import java.util.List;

import org.quicky.model.Book;

/**
 * @author Emmanuel
 *
 */
public interface BookDao {
	
	public List<Book> findAll();
	public Book findById(long id);
	public void create(Book book);
	public void update(Book book);
	public void delete(Book book);
	
}
