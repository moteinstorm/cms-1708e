package com.e1708.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.e1708.cms.entity.Article;
import com.e1708.cms.entity.Category;
import com.e1708.cms.entity.Channel;

public interface ArticleMapper {

	/**
	 * 根据用户获取文章的列表
	 * @param id
	 * @return
	 */
	
	List<Article> listByUser(Integer id);

	@Update("UPDATE cms_article SET deleted=#{status} WHERE id=#{id}")
	int updateStatus(@Param("id")int id, @Param("status") int status);

	/**
	 * 获取所有栏目的方法
	 * @return
	 */
	@Select("SELECT id,name FROM cms_channel")
	List<Channel> getAllChannels();
	

	/**
	 * 根据栏目id 获取分类
	 * @cid  ： 栏目的id
	 * @return
	 */
	@Select("SELECT id,name FROM cms_category WHERE channel_id = #{value}")
	List<Category> getCategorisByCid(int cid);

	
	@Insert("INSERT INTO cms_article(title,content,picture,channel_id,category_id,user_id,hits,hot,status,deleted,created,updated,commentCnt,articleType)"
			+ " VALUES(#{title},#{content},#{picture},#{channelId},#{categoryId},#{userId},0,0,0,0,now(),now(),0,#{articleType})")
	int add(Article article);
	
}
