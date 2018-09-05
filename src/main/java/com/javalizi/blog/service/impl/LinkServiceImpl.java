package com.javalizi.blog.service.impl;

import com.javalizi.blog.mapper.LinkMapper;
import com.javalizi.blog.pojo.Link;
import com.javalizi.blog.pojo.LinkExample;
import com.javalizi.blog.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Resource
	private LinkMapper linkMapper;


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
		return null;
	}

	@Override
	public Integer update(Link link) {
		return null;
	}

	@Override
	public Integer delete(Integer id) {
		return null;
	}
}
