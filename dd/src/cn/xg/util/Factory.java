package cn.xg.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * ��̬�� ���������ָ������Ķ���
 * �ӿ� ������ = new ʵ����();
 * 
 * ==>����ģʽ
 * 
 * �ӿ� ������ = Factory.getInstance(key);
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
		//���ݽӿ����ҵ���Ӧ������
		String className = props.getProperty(type);
		//���䴴��ʵ��
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
