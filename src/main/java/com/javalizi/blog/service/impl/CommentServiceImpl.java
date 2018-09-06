package com.javalizi.blog.service.impl;

import com.javalizi.blog.mapper.BlogMapper;
import com.javalizi.blog.mapper.CommentMapper;
import com.javalizi.blog.pojo.Blog;
import com.javalizi.blog.pojo.Comment;
import com.javalizi.blog.pojo.CommentExample;
import com.javalizi.blog.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
@Service("commentService")
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentMapper commentMapper;
	@Resource
	private BlogMapper blogMapper;

	@Override
	public List<Comment> list(Map<String, Object> map) {
		CommentExample example = new CommentExample();
		CommentExample.Criteria criteria = example.createCriteria();
		criteria.andBlogidEqualTo((Integer) map.get("blogId"));
		criteria.andStateEqualTo((Integer)map.get("state"));
		return commentMapper.selectByExample(example);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int add(Comment comment) {
		Blog blog=blogMapper.selectByPrimaryKey(comment.getBlogid());
		blogMapper.updateReplyHit(comment.getBlogid(),blog.getReplyhit()+1);
		return commentMapper.insertSelective(comment);
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
