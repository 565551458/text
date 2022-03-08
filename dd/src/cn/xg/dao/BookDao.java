package cn.xg.dao;

import java.util.List;
import java.util.Map;

import cn.xg.entity.Book;
import cn.xg.entity.Category;
import cn.xg.entity.Product;

public interface BookDao {

	List<Book> findRecommend();

	List<Book> findNew(int size);

	List<Book> findhot(int size);

	List<Book> findAll();

	List<Book> findByPid(int pid);

	List<Book> findByPidPage(int pid, int page, int size);

	List<Book> findByPidPageorder(int pid, int page, int size, String orderstr);

	int findSubNum(int id);
}
