/**
 * 
 */
package org.quicky.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.quicky.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Emmanuel
 *
 */
@Repository
@Transactional
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		return getSession().createQuery("from Book").list();
	}

	@Override
	public Book findById(long id) {
		return (Book)getSession().load(Book.class, id);
	}

	@Override
	public void create(Book book) {
		getSession().save(book);
	}

	@Override
	public void update(Book book) {
		getSession().update(book);
	}

	@Override
	public void delete(Book book) {
		getSession().delete(book);
	}

}
