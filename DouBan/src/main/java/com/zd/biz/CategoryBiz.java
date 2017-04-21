package com.zd.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zd.bean.Category;

@Service
public interface CategoryBiz {
	public List<Category> showCategory();
}
