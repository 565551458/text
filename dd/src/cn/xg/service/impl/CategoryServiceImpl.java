package cn.xg.service.impl;

import java.util.List;

import cn.xg.dao.BookDao;
import cn.xg.dao.CategoryDao;
import cn.xg.dao.impl.BookDaoImpl;
import cn.xg.dao.impl.CategoryDaoImpl;
import cn.xg.entity.Category;
import cn.xg.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	private BookDao bookDao = new BookDaoImpl();
	public CategoryDao categoryDao = new CategoryDaoImpl();
	
	public List<Category> findCatsByPid(int pid) {
		List<Category> list = categoryDao.findByPid(pid);
		for (Category category : list) {
			int id = category.getId();
			List<Category> sonList = categoryDao.findByPid(id);
			category.setSubCategory(sonList);

			
			int subNum = bookDao.findSubNum(id);
			category.setSubNum(subNum);
		}
		return list;
	}

}
