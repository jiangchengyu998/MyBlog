package com.javalizi.blog.service;


import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public interface BlogService {

	/**
	 * @param blog
	 * @param start
	 * @param size
	 * @return
	 */
	PageInfo<Blog> selectByPage(Blog blog, int start, int size);

	/**
	 * @return
	 */
	public List<Blog> countList();
	
	/**
	 * @param map
	 * @return
	 */
	public List<Blog> list(Map<String, Object> map);

	/**
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * @param id
	 * @return
	 */
	public Blog findById(Integer id);
	
	/**
	 * @param blog
	 * @return
	 */
	public Integer update(Blog blog);
	
	/**
	 * @param id
	 * @return
	 */
	public Blog getLastBlog(Integer id);
	
	/**
	 * @param id
	 * @return
	 */
	public Blog getNextBlog(Integer id);
	
	/**
	 * @param blog
	 * @return
	 */
	public Integer add(Blog blog);
	
	/**
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
	/**
	 * @param typeId
	 * @return
	 */
	public Integer getBlogByTypeId(Integer typeId);
}
