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

public class NewServlet extends HttpServlet{
	private BookService bookService = new BookServiceImpl();
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.
		ServletConfig config = this.getServletConfig();
		String size = config.getInitParameter("size");
		System.out.println("NewServlet:"+size);
		//2.
		List<Book> bookList = bookService.findNew(Integer.parseInt(size));
		
		//3.
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("new.jsp").forward(request, response);
	}
}
