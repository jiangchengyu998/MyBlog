package com.javalizi.blog.service;


import com.javalizi.blog.pojo.Comment;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public interface CommentService {

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
	
	/**
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
}
