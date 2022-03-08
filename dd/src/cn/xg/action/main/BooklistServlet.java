package cn.xg.action.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xg.entity.Book;
import cn.xg.entity.Category;
import cn.xg.service.BookService;
import cn.xg.service.CategoryService;
import cn.xg.service.impl.BookServiceImpl;
import cn.xg.service.impl.CategoryServiceImpl;

public class BooklistServlet extends HttpServlet{
	
	private BookService bookService = new BookServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pidStr = request.getParameter("pid");
		int pid = Integer.parseInt(pidStr);
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		//分页相关的参数
		int size =5;
		int page = 1;
		String pageStr = request.getParameter("page");
		if(pageStr!=null && ! pageStr.equals("")){
			page=Integer.parseInt(pageStr);
		}
		//排序相关的参数
		String orderstr = request.getParameter("orderstr");
		if(orderstr == null || orderstr.equals("")){
			orderstr = "add_time desc";//默认为 order by 。。。  
		}
		
		//左边部分
			List<Category> categoryList = categoryService.findCatsByPid(pid);
			int totalNum = getTotalNum(categoryList);//该分类下所有的商品总数
		//List<Book> bookList = bookService.findAll();
	
	//	List<Book> bookList = bookService.findByPid(pid);
		
		
		//List<Book> bookList = bookService.findByPidPage(pid,page,size);
		//int maxPage  =bookService.getMaxPage(pid,size);
		
		List<Book> bookList = bookService.findByPidPageorder(pid,page,size,orderstr);
		int maxPage  =bookService.getMaxPage(pid,size);
		
		//左边部分
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("totalNum", totalNum);
		
		
		request.setAttribute("bookList", bookList);
		request.setAttribute("pid", pid);
		request.setAttribute("id", id);
		request.setAttribute("currentpage", page);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("orderstr", orderstr);
		request.getRequestDispatcher("book_list.jsp").forward(request, response);
	}

	private int getTotalNum(List<Category> categoryList) {
		int totalNum = 0;
		for (Category category : categoryList) {
			totalNum += category.getSubNum();
		}
		return totalNum;
	}

}
