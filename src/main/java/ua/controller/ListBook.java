package ua.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.dao.BookDao;
import ua.dao.BookDaoImplementation;
import ua.entity.Book;

public class ListBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDAO = new BookDaoImplementation();
		try {
			List<Book> listBook = bookDAO.findAll();
			request.setAttribute("listBook", listBook);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("BookList.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}