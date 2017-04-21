package com.zd.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zd.bean.Book;
@Service
public interface BookBiz {
	public List<Book> showbook();
	public boolean addBook(Book book);
	public Book findOne(Book book);
	public boolean updatebook(Book book);
	public List<Book> showbookBycategory(String cid);
}
