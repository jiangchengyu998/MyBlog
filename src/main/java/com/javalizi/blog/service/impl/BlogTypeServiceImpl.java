package com.javalizi.blog.service.impl;

import com.javalizi.blog.mapper.BlogTypeMapper;
import com.javalizi.blog.pojo.BlogType;
import com.javalizi.blog.pojo.BlogTypeExample;
import com.javalizi.blog.service.BlogTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

	@Resource
	private BlogTypeMapper blogTypeMapper;


	@Override
	public List<BlogType> countList() {
		BlogTypeExample example = new BlogTypeExample();
//		example.createCriteria().
		example.setOrderByClause("orderno");
		return blogTypeMapper.selectByExample(example);
	}

	@Override
	public List<BlogType> list(Map<String, Object> map) {
		return null;
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return null;
	}

	@Override
	public Integer add(BlogType blogType) {
		return null;
	}

	@Override
	public Integer update(BlogType blogType) {
		return null;
	}

	@Override
	public Integer delete(Integer id) {
		return null;
	}
}
