package com.wwt.util;
import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyUtil {
	
	//1.��ȡ�����ļ�
	private static SqlSessionFactory factory;
	static{
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//2.����session
	public static SqlSession getSession(){
		return factory.openSession(false);//��ʹ���Զ��ύ����
	}
	//3.�ر�session
	public static void closeSession(SqlSession session){
		if(session != null) session.close();
	}
}
