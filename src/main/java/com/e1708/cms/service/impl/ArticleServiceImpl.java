package com.e1708.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e1708.cms.common.CmsContant;
import com.e1708.cms.dao.ArticleMapper;
import com.e1708.cms.entity.Article;
import com.e1708.cms.entity.Category;
import com.e1708.cms.entity.Channel;
import com.e1708.cms.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author zhuzg
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	ArticleMapper articleMapper;

	@Override
	public PageInfo<Article> listByUser(Integer id, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, CmsContant.PAGE_SIZE);
		PageInfo<Article> articlePage=  new PageInfo<Article>(articleMapper.listByUser(id));
		
		return articlePage;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return articleMapper.updateStatus(id,CmsContant.ARTICLE_STATUS_DEL);
	}

	@Override
	public List<Channel> getChannels() {
		// TODO Auto-generated method stub
		return articleMapper.getAllChannels();
	}

	@Override
	public List<Category> getCategorisByCid(int cid) {
		// TODO Auto-generated method stub
		return articleMapper.getCategorisByCid(cid);
	}

	@Override
	public int add(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.add(article);
		
	}

	@Override
	public Article getById(int id) {
		// TODO Auto-generated method stub
		return articleMapper.findById(id);
	}

	@Override
	public int update(Article article, Integer userId) {
		// TODO Auto-generated method stub
		Article articleSrc = this.getById(article.getId());
		if(articleSrc.getUserId() != userId) {
			// todo 如果  不是自己的文章 需要。。。。。
		}
		return articleMapper.update(article);
		
	}

	@Override
	public PageInfo<Article> list(int status, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, CmsContant.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.list(status));
	}

	
}
