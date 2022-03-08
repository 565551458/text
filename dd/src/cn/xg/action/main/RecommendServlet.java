package cn.xg.action.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xg.entity.Book;
import cn.xg.service.BookService;
import cn.xg.service.impl.BookServiceImpl;

public class RecommendServlet  extends HttpServlet{
	private BookService bookService = new BookServiceImpl();
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Book> bookList = bookService.findRecommend();
		
		
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("recommend.jsp").forward(request, response);
	}
}
