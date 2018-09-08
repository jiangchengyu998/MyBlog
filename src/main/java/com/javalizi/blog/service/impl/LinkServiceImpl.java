package com.javalizi.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javalizi.blog.mapper.LinkMapper;
import com.javalizi.blog.pojo.CommentExample;
import com.javalizi.blog.pojo.Link;
import com.javalizi.blog.pojo.LinkExample;
import com.javalizi.blog.service.LinkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 *
 */
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Resource
	private LinkMapper linkMapper;


	@Override
	public PageInfo<Link> selectByPage(Link link, int start, int size) {
		LinkExample example = new LinkExample();
		LinkExample.Criteria criteria = example.createCriteria();
		PageHelper.startPage(start, size);
		List<Link> comments = linkMapper.selectByExample(example);
		return new PageInfo<>(comments);
	}

	@Override
	public List<Link> list(LinkExample example) {
		return linkMapper.selectByExample(example);
	}

	@Override
	public Long getTotal(LinkExample example) {
		return null;
	}

	@Override
	public Integer add(Link link) {
		return linkMapper.insertSelective(link);
	}

	@Override
	public Integer update(Link link) {
		return linkMapper.updateByPrimaryKeySelective(link);
	}

	@Override
	public Integer delete(Integer id) {
		return null;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public Integer delete(String ids) {
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			linkMapper.deleteByPrimaryKey(Integer.parseInt(idsStr[i]));
		}
		return 1;
	}
}
