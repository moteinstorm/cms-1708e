package com.e1708.cms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e1708.cms.entity.Article;
import com.e1708.cms.service.ArticleService;
import com.github.pagehelper.PageInfo;

@RequestMapping("admin")
@Controller
public class AdminController {
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}
	
	
	@RequestMapping("article")
	public String article(HttpServletRequest request,int status ,int page) {
		PageInfo<Article> articlePage =  articleService.list(status ,page);
		request.setAttribute("articlePage", articlePage);
		return "admin/article/list";
		
	}
	
	
}
