package cn.xg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xg.dao.BookDao;
import cn.xg.entity.Book;
import cn.xg.entity.Category;
import cn.xg.util.DBUtil;

public class BookDaoImpl implements BookDao {

	public List<Book> findRecommend() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select author,publishing,publish_time,product_name,description"
				+ ",fixed_price,dang_price,product_pic from d_book db "
				+ "	join d_product dp on db.id=dp.id limit 0,2";
		List<Book> list = new ArrayList<Book>();
		
		try {
			conn=DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublish_time(rs.getLong("publish_time"));
				book.setDescription(rs.getString("description"));
				book.setProduct_name(rs.getString("product_name"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setProduct_pic(rs.getString("product_pic"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}	
		
		return list;
	}

	public List<Book> findNew(int size) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select publish_time,product_name,product_pic,add_time,fixed_price,dang_price "
				+ " from d_book b join d_product p"
				+ " on b.id = p.id  "
				+ " order by add_time desc "
				+ " limit 0,? ";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, size);
			rs = ps.executeQuery();
			
			List<Book> bookList = new ArrayList<Book>();
			while(rs.next()){
				Book book = new Book();
				//处理对应属性
				book.setPublish_time(rs.getLong("publish_time"));
				book.setProduct_name(rs.getString("product_name"));
				book.setProduct_pic(rs.getString("product_pic"));
				book.setAdd_time(rs.getLong("add_time"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				
				bookList.add(book);
			}
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	public List<Book> findhot(int size) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select publish_time,product_name,product_pic,add_time,fixed_price,dang_price "
				+ " from d_book b join d_product p"
				+ " on b.id = p.id  "
				+ " order by dang_price desc "
				+ " limit 0,? ";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, size);
			rs = ps.executeQuery();
			
			List<Book> bookList = new ArrayList<Book>();
			while(rs.next()){
				Book book = new Book();
				//处理对应属性
				book.setPublish_time(rs.getLong("publish_time"));
				book.setProduct_name(rs.getString("product_name"));
				book.setProduct_pic(rs.getString("product_pic"));
				book.setAdd_time(rs.getLong("add_time"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				
				bookList.add(book);
			}
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	public List<Book> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select author,publishing,publish_time,product_name,description"
				+ ",fixed_price,dang_price,product_pic from d_book db "
				+ "	join d_product dp on db.id=dp.id ";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<Book> bookList = new ArrayList<Book>();
			while(rs.next()){
				Book book = new Book();
				//处理对应属性
				book.setPublish_time(rs.getLong("publish_time"));
				book.setProduct_name(rs.getString("product_name"));
				book.setProduct_pic(rs.getString("product_pic"));
				//book.setAdd_time(rs.getLong("add_time"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				bookList.add(book);
			}
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	public List<Book> findByPid(int pid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select publishing,publish_time,author,fixed_price,dang_price,total_page,publish_time,product_name,product_pic,description "
				+ " from d_book b join d_product p"
				+ " on b.id = p.id  "
				+ " join d_category_product cp "
				+ " on p.id = cp.product_id "
				+ " where cp.cat_id = ? ";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			
			List<Book> bookList = new ArrayList<Book>();
			while(rs.next()){
				Book book = new Book();
				//处理对应属性
				book.setPublishing(rs.getString("publishing"));
				book.setPublish_time(rs.getLong("publish_time"));
				book.setAuthor(rs.getString("author"));
				book.setTotal_page(rs.getString("total_page"));
				book.setProduct_name(rs.getString("product_name"));
				book.setProduct_pic(rs.getString("product_pic"));
				book.setDescription(rs.getString("description"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				bookList.add(book);
			}
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
		
	}

	public List<Book> findByPidPage(int pid, int page, int size) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select publishing,publish_time,author,total_page,dang_price,fixed_price,publish_time,product_name,product_pic,description "
				+ " from d_book b join d_product p"
				+ " on b.id = p.id  "
				+ " join d_category_product cp "
				+ " on p.id = cp.product_id "
				+ " where cp.cat_id = ? "
				+ " limit ?,?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, (page-1)*size);
			ps.setInt(3, size);
			rs = ps.executeQuery();
			
			List<Book> bookList = new ArrayList<Book>();
			while(rs.next()){
				Book book = new Book();
				//处理对应属性
				book.setPublishing(rs.getString("publishing"));
				book.setPublish_time(rs.getLong("publish_time"));
				book.setAuthor(rs.getString("author"));
				book.setTotal_page(rs.getString("total_page"));
				book.setProduct_name(rs.getString("product_name"));
				book.setProduct_pic(rs.getString("product_pic"));
				book.setDescription(rs.getString("description"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				bookList.add(book);
			}
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	public List<Book> findByPidPageorder(int pid, int page, int size, String orderstr) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select publishing,publish_time,author,total_page,dang_price,fixed_price,publish_time,product_name,product_pic,description "
				+ " from d_book b join d_product p"
				+ " on b.id = p.id  "
				+ " join d_category_product cp "
				+ " on p.id = cp.product_id "
				+ " where cp.cat_id = ? "
				+ " order by "+orderstr
				+ " limit ?,?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, (page-1)*size);
			ps.setInt(3, size);
			rs = ps.executeQuery();
			
			List<Book> bookList = new ArrayList<Book>();
			while(rs.next()){
				Book book = new Book();
				//处理对应属性
				book.setPublishing(rs.getString("publishing"));
				book.setPublish_time(rs.getLong("publish_time"));
				book.setAuthor(rs.getString("author"));
				book.setTotal_page(rs.getString("total_page"));
				book.setProduct_name(rs.getString("product_name"));
				book.setProduct_pic(rs.getString("product_pic"));
				book.setDescription(rs.getString("description"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				bookList.add(book);
			}
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	public int findSubNum(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(1) subNum from d_category_product where cat_id = ?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			int result = -1;
			if(rs.next()){
				result = rs.getInt("subNum");
			}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	
	

}
