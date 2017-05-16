package ua.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.entity.Book;
import ua.util.DbUtil;

public class BookDaoImplementation implements BookDao {

	DbUtil dbUtil = new DbUtil();

	@Override
	public boolean addBook(Book book) throws SQLException {
		String sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";

		Connection conn = dbUtil.connect();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, book.getTitle());
		statement.setString(2, book.getAuthor());
		statement.setFloat(3, book.getPrice());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		dbUtil.disconnect();
		return rowInserted;
	}

	@Override
	public List<Book> findAll() throws SQLException {
		List<Book> listBook = new ArrayList<>();

		String sql = "SELECT * FROM book";

		Connection conn = dbUtil.connect();

		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("book_id");
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			float price = resultSet.getFloat("price");

			Book book = new Book();
			book.setId(id);
			book.setAuthor(author);
			book.setPrice(price);
			book.setTitle(title);
			listBook.add(book);
		}

		resultSet.close();
		statement.close();

		dbUtil.disconnect();

		return listBook;
	}

	@Override
	public boolean deleteBook(Book book) throws SQLException {
		String sql = "DELETE FROM book where book_id = ?";

		Connection conn = dbUtil.connect();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, book.getId());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		dbUtil.disconnect();
		return rowDeleted;
	}

	@Override
	public boolean updateBook(Book book) throws SQLException {
		String sql = "UPDATE book SET title = ?, author = ?, price = ?";
		sql += " WHERE book_id = ?";
		Connection conn = dbUtil.connect();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, book.getTitle());
		statement.setString(2, book.getAuthor());
		statement.setFloat(3, book.getPrice());
		statement.setInt(4, book.getId());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		dbUtil.disconnect();
		return rowUpdated;
	}

	@Override
	public Book findOne(int id) throws SQLException {
		Book book = null;
		String sql = "SELECT * FROM book WHERE book_id = ?";

		Connection conn = dbUtil.connect();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			float price = resultSet.getFloat("price");

			book = new Book();
			book.setAuthor(author);
			book.setPrice(price);
			book.setTitle(title);
		}

		resultSet.close();
		statement.close();

		return book;
	}
}