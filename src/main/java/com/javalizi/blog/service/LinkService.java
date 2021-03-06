package com.javalizi.blog.service;


import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.Link;
import com.javalizi.blog.pojo.LinkExample;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface LinkService {

	PageInfo<Link> selectByPage(Link link, int start, int size);


	/**
	 * @param example
	 * @return
	 */
	public List<Link> list(LinkExample example);

	/**
	 * @param example
	 * @return
	 */
	public Long getTotal(LinkExample example);
	
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

	public Integer delete(String ids);
}
