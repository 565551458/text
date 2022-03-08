package cn.xg.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	private static String url;
	private static String username;
	private static String pwd;
	
	
	static {
		Properties p = new Properties();
		
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("cn/xg/util/db.properties"));
		
			String driver = p.getProperty("driver");
			url=p.getProperty("url");
			username=p.getProperty("username");
			pwd=p.getProperty("pwd");
		
			Class.forName(driver);
		
		} catch (IOException e) {
			System.out.println("db�����ļ�δ�ҵ���");
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ�ܣ�");
		}
		
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, pwd);
	}
	
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}

