package com.zd.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zd.bean.Book;
import com.zd.biz.BookBiz;
import com.zd.dao.BaseDao;


@Service
@Transactional(readOnly = true)
public class BookBizImpl implements BookBiz{
	
	private BaseDao baseDao;
	@Resource(name="baseDaoImpl")
	public void setBaseDao(BaseDao baseDao){
		this.baseDao=baseDao;
	}

	
	@Override
	public List<Book> showbook() {
		Book book=new Book();
		List<Book> list=this.baseDao.findAll(book, "showbook");
		return list;
	}
	


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public boolean addBook(Book book) {
		try {
			this.baseDao.add(book, "addBook");
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	@Override
	public Book findOne(Book book) {
		List<Book> list=this.baseDao.findAll(book, "findOne");
		return list.get(0);
	}
	
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public boolean updatebook(Book book) {
		try {
			this.baseDao.update(book, "updateBook");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@Override
	public List<Book> showbookBycategory(String cid) {
		int c_id=Integer.parseInt(cid);
		if(c_id<=0){
			return showbook();
		}
		Book book=new Book();
		book.setB_c_id(Integer.parseInt(cid));
		List<Book> list=this.baseDao.findAll(book, "showbookBycid");
		return list;
	}




}
