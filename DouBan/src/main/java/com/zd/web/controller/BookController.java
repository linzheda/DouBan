package com.zd.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.zd.bean.Book;
import com.zd.bean.Category;
import com.zd.biz.BookBiz;
import com.zd.biz.CategoryBiz;
import com.zd.util.UploadFileUtil;
import com.zd.util.UploadFileUtil.UploadFile;


@Controller
public class BookController {
	private BookBiz bb;
	private CategoryBiz cb;
	private String pdfRootName="uploadPdfs";
	
	@Resource(name="categoryBizImpl")
	public void setBb(CategoryBiz cb) {
		this.cb = cb;
	}
	@Resource(name="bookBizImpl")
	public void setBb(BookBiz bb) {
		this.bb = bb;
	}
	
	@RequestMapping("AdminWelcome.action")
	public String adminwelcome() {
		System.out.println("进入登录界面");
		return "admin/login";
	}
	
	@RequestMapping("admin/adminLogin.action")
	public String adminLogin(@RequestParam String uname,@RequestParam String password,HttpSession session ) {
		InputStream inputStream=this.getClass().getClassLoader().getResourceAsStream("adminLogin.properties");
		Properties p=new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(p.getProperty("uname").equals(uname)&&p.getProperty("password").equals(password)){
			session.setAttribute("uname", uname);
			return "redirect:/admin/ToMain.action";
		}else{
			session.setAttribute("errmsg", "用户名或密码错误");
			return "redirect:/AdminWelcome.action";
		}
	}
	@RequestMapping("admin/ToMain.action")
	public ModelAndView toMain() {
		System.out.println("进入主界面");
		ModelAndView mv=new ModelAndView("admin/main");
		List<Book> list=this.bb.showbook();
		mv.addObject("list", list);
		return mv;
	}
	@RequestMapping("admin/ToAdd.action")
	public ModelAndView toAdd() {
		System.out.println("进入添加书界面");
		ModelAndView mv=new ModelAndView("admin/addBook");
		List<Category> list=this.cb.showCategory();
		mv.addObject("categoryList", list);
		return mv;
	}
	
	@RequestMapping("admin/add_book.action")
	public ModelAndView addsuccess(HttpServletRequest request,Book book) {
		System.out.println("添加书籍成功进入主界面");
		
		
		String pdfs="";
		Map<String, UploadFile> map=UploadFileUtil.uploadFile(request, book.getPdfsUrl(), pdfRootName);
		for(Entry<String,UploadFile> entry:map.entrySet()){
			UploadFile uploadFile=entry.getValue();
			pdfs+=uploadFile.getNewFileUrl()+"-";
		}
		book.setB_pdfs(pdfs);
		
		boolean isSuccess=this.bb.addBook(book);
		if(isSuccess){
			ModelAndView mv=new ModelAndView("redirect:/admin/ToMain.action");
			return mv;
		}else{
			ModelAndView mv=new ModelAndView("redirect:/admin/ToAdd.action");
			List<Category> list=this.cb.showCategory();
			mv.addObject("categoryList", list);
			return mv; 
		}
	}
	
	@RequestMapping("admin/ToEdit.action/{b_id}")
	public ModelAndView toEdidBook( @PathVariable(value="b_id") int b_id ) {
		System.out.println("进入编辑界面");
		ModelAndView mv=new ModelAndView("admin/editBook");
		Book book=new Book();
		book.setB_id(b_id);
		book=this.bb.findOne(book);
		mv.addObject("book", book);
		List<Category> list=this.cb.showCategory();
		mv.addObject("categoryList", list);
		return mv;
	}
	
	@RequestMapping("admin/edit_book.action")
	public ModelAndView editsuccess(HttpServletRequest request,Book book) {
		
		String pdfs="";
		Map<String, UploadFile> map=UploadFileUtil.uploadFile(request, book.getPdfsUrl(), pdfRootName);
		for(Entry<String,UploadFile> entry:map.entrySet()){
			UploadFile uploadFile=entry.getValue();
			pdfs+=uploadFile.getNewFileUrl()+"-";
		}
		book.setB_pdfs(pdfs);
		boolean isSuccess=this.bb.updatebook(book);
		if(isSuccess){
			System.out.println("修改书籍成功进入主界面");
			ModelAndView mv=new ModelAndView("redirect:/admin/ToMain.action");
			return mv;
		}else{
			System.out.println("修改书籍失败，返回");
			ModelAndView mv=new ModelAndView("redirect:/edit.action/"+book.getB_id());
			return mv; 
		}
	}
	
	@RequestMapping("admin/score.action/{b_id}")
	public ModelAndView score(@PathVariable(value="b_id") int b_id) {
		System.out.println("进入评价书界面");
		ModelAndView mv=new ModelAndView("admin/score");
		Book book=new Book();
		book.setB_id(b_id);
		book=this.bb.findOne(book);
		mv.addObject("book", book);
		return mv;
	}
	@RequestMapping("admin/score_book.action")
	public ModelAndView scorBook(Book book) {
		
		boolean isSuccess=this.bb.updatebook(book);
		if(isSuccess){
			System.out.println("评价书籍成功进入主界面");
			ModelAndView mv=new ModelAndView("redirect:/admin/ToMain.action");
			return mv;
		}else{
			System.out.println("评价书籍失败，返回");
			ModelAndView mv=new ModelAndView("redirect:/score.action/"+book.getB_id());
			return mv; 
		}
	}
	
	
	
	
}
