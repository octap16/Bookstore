package ua.dao;

import java.sql.SQLException;
import java.util.List;

import ua.entity.Book;

public interface BookDao {

	public boolean addBook(Book book) throws SQLException;

	public List<Book> findAll() throws SQLException;

	public boolean deleteBook(Book book) throws SQLException;

	public boolean updateBook(Book book) throws SQLException;

	public Book findOne(int id) throws SQLException;

}
