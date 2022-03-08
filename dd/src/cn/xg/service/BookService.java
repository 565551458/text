package cn.xg.service;

import java.util.List;

import cn.xg.entity.Book;
import cn.xg.entity.Category;

public interface BookService {

	List<Book> findRecommend();

	List<Book> findNew(int size);

	List<Book> findHot(int size);

	List<Book> findAll();

	List<Book> findByPid(int pid);

	List<Book> findByPidPage(int pid, int page, int size);

	int getMaxPage(int pid, int size);

	List<Book> findByPidPageorder(int pid, int page, int size, String orderstr);


}
