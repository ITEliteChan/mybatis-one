package com.ch.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MybatisUtil {

	public static  SqlSession getSession() {
	
		InputStream in=null;
		try {
		 in = Resources.getResourceAsStream("Mybatis-cofig.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ÎÄ¼þÎ´ÕÒµ½");
		}
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		return sf.openSession();
	}
}
