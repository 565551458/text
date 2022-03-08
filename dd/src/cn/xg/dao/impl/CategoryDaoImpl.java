package cn.xg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.xg.dao.CategoryDao;
import cn.xg.entity.Category;
import cn.xg.util.DBUtil;

public class CategoryDaoImpl  implements CategoryDao{

	public List<Category> findByPid(int pid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id,turn,en_name,name,description,parent_id "
				+ " from d_category where parent_id = ? ";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			
			List<Category> categoryList = new ArrayList<Category>();
			while(rs.next()){
				Category category = new Category();
				//处理对应属性
				category.setId(rs.getInt("id"));
				category.setTurn(rs.getInt("turn"));
				category.setEnName(rs.getString("en_name"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
				category.setParentId(rs.getInt("parent_id"));
				
				
				categoryList.add(category);
			}
			return categoryList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}


}
