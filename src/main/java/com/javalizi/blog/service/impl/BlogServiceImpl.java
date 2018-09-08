package com.javalizi.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javalizi.blog.mapper.BlogMapper;
import com.javalizi.blog.pojo.Blog;
import com.javalizi.blog.pojo.BlogExample;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
@Service("blogService")
public class BlogServiceImpl implements BlogService {

	@Resource
	private BlogMapper blogMapper;

	/**
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
		if(StringUtil.isNotEmpty(blog.getReleaseDateStr())){
			example.setReleaseDateStr(blog.getReleaseDateStr());
		}
		PageHelper.startPage(start, size);
		List<Blog> blogs = blogMapper.selectByExampleWithBLOBs(example);
		return new PageInfo<>(blogs);
	}

	/**
	 * @return
	 */
	@Override
	public List<Blog> countList() {
		return blogMapper.countList();
	}

	/**
	 * @param map
	 * @return
	 */
	@Override
	public List<Blog> list(Map<String, Object> map) {
		return null;
	}

	/**
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
		return blogMapper.updateByPrimaryKeySelective(blog);
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
		blog.setReleasedate(new Date());
		blog.setReplyhit(0);
		blog.setClickhit(0);
		return blogMapper.insertSelective(blog);
	}

	@Override
	public Integer delete(Integer id) {
		return blogMapper.deleteByPrimaryKey(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public Integer delete(String id) {
		int result = 0;
		String []idsStr=id.split(",");
		for (String s : idsStr) {
			result = blogMapper.deleteByPrimaryKey(Integer.parseInt(s));
		}
		return result;
	}

	@Override
	public Integer getBlogByTypeId(Integer typeId) {
		BlogExample example = new BlogExample();
		BlogExample.Criteria criteria = example.createCriteria();
		criteria.andTypeidEqualTo(typeId);
		List<Blog> blogs = blogMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(blogs)){
			return 1;
		}
		return 0;
	}
}
