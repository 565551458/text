package cn.xg.service.impl;

import java.util.List;

import cn.xg.dao.BookDao;
import cn.xg.dao.impl.BookDaoImpl;
import cn.xg.entity.Book;
import cn.xg.service.BookService;

public class BookServiceImpl implements BookService{
	private BookDao bookDao = new BookDaoImpl();
	public List<Book> findRecommend() {
		return bookDao.findRecommend();
	}
	public List<Book> findHot(int size) {
		return bookDao.findhot(size);
	}
	public List<Book> findNew(int size) {
		return bookDao.findNew(size);
	}
	public List<Book> findAll() {
		return bookDao.findAll();
	}
	public List<Book> findByPid(int pid) {
		return bookDao.findByPid(pid);
	}
	public List<Book> findByPidPage(int pid, int page, int size) {
		return bookDao.findByPidPage(pid,page,size);
	}
	public int getMaxPage(int pid, int size) {
		List<Book> bookList=bookDao.findByPid(pid);
		return (bookList.size()-1)/(size+1); 
	}
	public List<Book> findByPidPageorder(int pid, int page, int size, String orderstr) {
		return bookDao.findByPidPageorder(pid,page,size,orderstr);
	}

	
	
}
