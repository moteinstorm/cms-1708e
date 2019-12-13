package com.e1708.cms.service;

import java.util.List;

import com.e1708.cms.entity.Article;
import com.e1708.cms.entity.Category;
import com.e1708.cms.entity.Channel;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author zhuzg
 *
 */
public interface ArticleService {

	/**
	 * 根据用户列出文章
	 * @param id
	 * @param page
	 * @return
	 */
	PageInfo<Article> listByUser(Integer id, int page);

	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	int delete(int id);

	/**
	 * 获取所有的栏目
	 * @return
	 */
	List<Channel> getChannels();
	
	List<Category> getCategorisByCid(int cid);

	/**
	 * 发布文章
	 * @param article
	 */
	int add(Article article);
	
	

}
