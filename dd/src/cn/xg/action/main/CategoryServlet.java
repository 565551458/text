package cn.xg.action.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xg.entity.Category;
import cn.xg.service.CategoryService;
import cn.xg.service.impl.CategoryServiceImpl;

public class CategoryServlet extends HttpServlet{
	
	private CategoryService categoryService = new CategoryServiceImpl();
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Category> categoryList = categoryService.findCatsByPid(1);
		
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("category.jsp").forward(request, response);
	}
}
