package com.javalizi.blog.service;


import com.javalizi.blog.pojo.Blogger;

/**
 * @author Administrator
 *
 */
public interface BloggerService {

	/**
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);
	
	/**
	 * @return
	 */
	public Blogger find();

	public Blogger find(Blogger blogger);

	/**
	 * @param blogger
	 * @return
	 */
	public Integer update(Blogger blogger);
}
