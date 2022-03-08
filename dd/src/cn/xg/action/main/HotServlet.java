package cn.xg.action.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xg.entity.Book;
import cn.xg.service.BookService;
import cn.xg.service.impl.BookServiceImpl;

public class HotServlet extends HttpServlet{
	private BookService bookService = new BookServiceImpl();
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletConfig config = this.getServletConfig();
		String size = config.getInitParameter("size");
		System.out.println("HotServlet:"+size);
		
		List<Book> bookList = bookService.findHot(Integer.parseInt(size));
		
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("hot.jsp").forward(request, response);
	}
}
