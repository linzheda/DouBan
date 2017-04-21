package com.zd.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zd.bean.Category;
import com.zd.biz.CategoryBiz;
import com.zd.dao.BaseDao;
@Service
@Transactional(readOnly = true)
public class CategoryBizImpl implements CategoryBiz{
	private BaseDao baseDao;
	@Resource(name="baseDaoImpl")
	public void setBaseDao(BaseDao baseDao){
		this.baseDao=baseDao;
	}
	
	
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public List<Category> showCategory() {
		Category c=new Category();
		List<Category> list=this.baseDao.findAll(c, "showCategory");
		return list;
	}
	
	
}
