package com.javalizi.blog.service.impl;

import com.javalizi.blog.mapper.BloggerMapper;
import com.javalizi.blog.pojo.Blogger;
import com.javalizi.blog.service.BloggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 博主Service实现类
 * @author Administrator
 *
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

	@Resource
	private BloggerMapper bloggerMapper;


	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	@Override
	public Blogger getByUserName(String userName) {
		return null;
	}

	/**
	 * 查询博主信息
	 * @return
	 */
	@Override
	public Blogger find() {
		return null;
	}

	/**
	 * 更新博主信息
	 * @param blogger
	 * @return
	 */
	@Override
	public Integer update(Blogger blogger) {
		return null;
	}
}
