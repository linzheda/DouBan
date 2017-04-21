package com.zd.test;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zd.bean.Book;
import com.zd.biz.BookBiz;

import junit.framework.TestCase;

public class TestSpring extends TestCase {

	
	public void testSpring1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BookBiz sb =  (BookBiz) ac.getBean("bookBizImpl");
		List<Book> list=sb.showbook();
	}
	
	public void testSpring2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		DataSource sb = (DataSource) ac.getBean("dataSource");
		System.out.println(sb);
	}
	public void testSpring3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Object sb =  ac.getBean("sqlSessionFactory");
		System.out.println(sb);
	}
	
	
}
