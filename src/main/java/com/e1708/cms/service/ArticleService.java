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

	/**
	 * 根据文章id获取文章对象
	 * @param id
	 * @return
	 */
	Article getById(int id);
	
	/**
	 * 获取文章的简要信息  常常用于判断文章的存在性
	 * @param id
	 * @return
	 */
	Article getInfoById(int id);

	/**
	 * 
	 * @param article
	 * @param id
	 * @return
	 */
	int update(Article article, Integer id);

	/**
	 * 获取文章列表
	 * @param status
	 * @param page
	 * @return
	 */
	PageInfo<Article> list(int status, int page);

	int setHot(int id, int status);

	int setCheckStatus(int id, int status);
	
	

}
