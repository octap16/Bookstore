package ua.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.dao.BookDao;
import ua.dao.BookDaoImplementation;
import ua.entity.Book;

public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDAO = new BookDaoImplementation();
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = new Book();
		book.setId(id);
		try {
			bookDAO.deleteBook(book);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		response.sendRedirect("list");
	}

}
