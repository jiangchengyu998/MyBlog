package com.javalizi.blog.service.impl;

import com.javalizi.blog.mapper.BloggerMapper;
import com.javalizi.blog.pojo.Blogger;
import com.javalizi.blog.pojo.BloggerExample;
import com.javalizi.blog.service.BloggerService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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
		BloggerExample example = new BloggerExample();
		List<Blogger> list = bloggerMapper.selectByExampleWithBLOBs(example);
		if (!CollectionUtils.isEmpty(list) && list.size() >0){
			return list.get(0);
		}else {
			return null;
		}
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
