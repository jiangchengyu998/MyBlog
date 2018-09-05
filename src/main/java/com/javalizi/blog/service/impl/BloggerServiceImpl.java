package com.javalizi.blog.service.impl;

import com.javalizi.blog.mapper.BloggerMapper;
import com.javalizi.blog.pojo.Blogger;
import com.javalizi.blog.service.BloggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 *
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

	@Resource
	private BloggerMapper bloggerMapper;


	/**
	 * @param userName
	 * @return
	 */
	@Override
	public Blogger getByUserName(String userName) {
		return null;
	}

	/**
	 * @return
	 */
	@Override
	public Blogger find() {
		return null;
	}

	/**
	 * @param blogger
	 * @return
	 */
	@Override
	public Integer update(Blogger blogger) {
		return null;
	}
}
