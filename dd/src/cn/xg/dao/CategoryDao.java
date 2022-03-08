package cn.xg.dao;

import java.util.List;

import cn.xg.entity.Category;

public interface CategoryDao {

	List<Category> findByPid(int pid);

}
