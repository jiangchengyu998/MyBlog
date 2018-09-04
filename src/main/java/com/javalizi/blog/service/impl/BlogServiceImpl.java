package com.javalizi.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javalizi.blog.mapper.BlogMapper;
import com.javalizi.blog.pojo.Blog;
import com.javalizi.blog.pojo.BlogExample;
import com.javalizi.blog.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 博客Service实现类
 * @author Administrator
 *
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

	@Resource
	private BlogMapper blogMapper;

	/**
	 * 分页查询博客列表
	 * @param blog
	 * @param start
	 * @param size
	 * @return
	 */
	@Override
	public PageInfo<Blog> selectByPage(Blog blog, int start, int size) {
		BlogExample example = new BlogExample();
		BlogExample.Criteria criteria = example.createCriteria();
		if(blog.getTypeid() != null){
			criteria.andTypeidEqualTo(blog.getTypeid());
		}
		PageHelper.startPage(start, size);
		List<Blog> blogs = blogMapper.selectByExampleWithBLOBs(example);
		return new PageInfo<>(blogs);
	}

	/**
	 * 根据日期分月分组查询
	 * @return
	 */
	@Override
	public List<Blog> countList() {
		BlogExample example = new BlogExample();
		return blogMapper.selectByExampleWithBLOBs(example);
	}

	/**
	 * 分页查询博客
	 * @param map
	 * @return
	 */
	@Override
	public List<Blog> list(Map<String, Object> map) {
		return null;
	}

	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	@Override
	public Long getTotal(Map<String, Object> map) {
		return null;
	}

	@Override
	public Blog findById(Integer id) {
		return blogMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer update(Blog blog) {
		return null;
	}

	@Override
	public Blog getLastBlog(Integer id) {
		return null;
	}

	@Override
	public Blog getNextBlog(Integer id) {
		return null;
	}

	@Override
	public Integer add(Blog blog) {
		return null;
	}

	@Override
	public Integer delete(Integer id) {
		return null;
	}

	@Override
	public Integer getBlogByTypeId(Integer typeId) {
		return null;
	}
}
