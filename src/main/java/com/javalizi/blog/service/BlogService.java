package com.javalizi.blog.service;


import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * 博客Service接口
 * @author Administrator
 *
 */
public interface BlogService {

	/**
	 * 分页查询博客列表
	 * @param blog
	 * @param start
	 * @param size
	 * @return
	 */
	PageInfo<Blog> selectByPage(Blog blog, int start, int size);

	/**
	 * 根据日期分月分组查询
	 * @return
	 */
	public List<Blog> countList();
	
	/**
	 * 分页查询博客
	 * @param map
	 * @return
	 */
	public List<Blog> list(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * 根据id查找实体
	 * @param id
	 * @return
	 */
	public Blog findById(Integer id);
	
	/**
	 * 更新博客信息
	 * @param blog
	 * @return
	 */
	public Integer update(Blog blog);
	
	/**
	 * 获取上一个博客
	 * @param id
	 * @return
	 */
	public Blog getLastBlog(Integer id);
	
	/**
	 * 获取下一个博客
	 * @param id
	 * @return
	 */
	public Blog getNextBlog(Integer id);
	
	/**
	 * 添加博客信息
	 * @param blog
	 * @return
	 */
	public Integer add(Blog blog);
	
	/**
	 * 删除博客信息
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
	/**
	 * 查询指定的博客类别下的博客数量
	 * @param typeId
	 * @return
	 */
	public Integer getBlogByTypeId(Integer typeId);
}
