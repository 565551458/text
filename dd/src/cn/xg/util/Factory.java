package cn.xg.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * 多态： 父类的引用指向子类的对象
 * 接口 变量名 = new 实现类();
 * 
 * ==>工厂模式
 * 
 * 接口 变量名 = Factory.getInstance(key);
 * 
 */
public class Factory {
	private static Properties props = 
		new Properties();
	static{
		try {
			props.load(Factory.class.getClassLoader()
					.getResourceAsStream("cn/xg/util/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Object getInstance(String type){
		Object obj = null;
		//依据接口名找到对应的类名
		String className = props.getProperty(type);
		//反射创建实例
		try {
			obj = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return obj;
	}
	
	public static void main(String[] args) {
		System.out.println(getInstance("userDao"));
	}
}
