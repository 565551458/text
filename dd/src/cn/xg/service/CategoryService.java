package cn.xg.service;

import java.util.List;

import cn.xg.entity.Category;

public interface CategoryService {

	List<Category> findCatsByPid(int i);

}
