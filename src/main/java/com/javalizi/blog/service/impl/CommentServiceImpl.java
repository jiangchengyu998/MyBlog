package com.javalizi.blog.service.impl;

import com.javalizi.blog.mapper.CommentMapper;
import com.javalizi.blog.pojo.Comment;
import com.javalizi.blog.pojo.CommentExample;
import com.javalizi.blog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 评论Service实现类
 * @author Administrator
 *
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentMapper commentMapper;


	@Override
	public List<Comment> list(Map<String, Object> map) {
		CommentExample example = new CommentExample();
		CommentExample.Criteria criteria = example.createCriteria();
		criteria.andBlogidEqualTo((Integer) map.get("blogId"));
		criteria.andStateEqualTo((Integer)map.get("state"));
		return commentMapper.selectByExample(example);
	}

	@Override
	public int add(Comment comment) {
		return 0;
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return null;
	}

	@Override
	public int update(Comment comment) {
		return 0;
	}

	@Override
	public Integer delete(Integer id) {
		return null;
	}
}
