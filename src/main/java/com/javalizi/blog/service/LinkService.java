package com.javalizi.blog.service;


import com.javalizi.blog.pojo.Link;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public interface LinkService {

	/**
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String, Object> map);

	/**
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * @param link
	 * @return
	 */
	public Integer add(Link link);
	
	/**
	 * @param link
	 * @return
	 */
	public Integer update(Link link);
	
	/**
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
}
