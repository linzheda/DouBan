package com.zd.web.controller;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.zd.bean.Book;
import com.zd.bean.Category;
import com.zd.biz.BookBiz;
import com.zd.biz.CategoryBiz;

@Controller
public class UserBookController {
	private BookBiz bb;
	private CategoryBiz cb;
	
	@Resource(name="categoryBizImpl")
	public void setBb(CategoryBiz cb) {
		this.cb = cb;
	}
	@Resource(name="bookBizImpl")
	public void setBb(BookBiz bb) {
		this.bb = bb;
	}
	
	
	@RequestMapping("UserWelcome.action")
	public ModelAndView userwelcome() {
		List<Category> categoryList=this.cb.showCategory();
		List<Book> list=this.bb.showbook();
		ModelAndView mv=new ModelAndView("userMain");
		mv.addObject("categoryList", categoryList);
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("findBookByType.action")
	public @ResponseBody String clickCategory(@RequestParam String cid) {
		List<Book> list=this.bb.showbookBycategory(cid);
		System.out.println(list);
		Gson gson=new Gson();
		return gson.toJson(list);
	}
	


	@RequestMapping("toDetailBook.action/{b_id}")
	public ModelAndView toDetailBook(@PathVariable String b_id) {
		Book b=new Book();
		b.setB_id(Integer.parseInt(b_id));
		b=this.bb.findOne(b);
		ModelAndView mv=new ModelAndView("detailBook");
		mv.addObject("book", b);
		return mv;
	}




}
