package com.javalizi.blog.service;


import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.BlogType;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public interface BlogTypeService {

	public PageInfo<BlogType> selectByPage(BlogType blogType, int start, int size);

	/**
	 * @return
	 */
	public List<BlogType> countList();
	
	/**
	 * @param map
	 * @return
	 */
	public List<BlogType> list(Map<String, Object> map);

	/**
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * @param blogType
	 * @return
	 */
	public Integer add(BlogType blogType);
	
	/**
	 * @param blogType
	 * @return
	 */
	public Integer update(BlogType blogType);
	
	/**
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);

	public Integer delete(String ids, JSONObject result);
}
