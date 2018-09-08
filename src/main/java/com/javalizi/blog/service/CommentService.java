package com.javalizi.blog.service;


import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.Comment;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public interface CommentService {

	PageInfo<Comment> selectByPage(Comment comment, int start, int size);

	/**
	 * @param map
	 * @return
	 */
	public List<Comment> list(Map<String, Object> map);

	/**
	 * @param comment
	 * @return
	 */
	public int add(Comment comment);

	/**
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * @param comment
	 * @return
	 */
	public int update(Comment comment);

	public int update(String ids, Integer state);

	/**
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);

	public Integer delete(String ids);
}
