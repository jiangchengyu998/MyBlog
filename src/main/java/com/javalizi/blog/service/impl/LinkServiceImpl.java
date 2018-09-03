package com.javalizi.blog.service.impl;

import com.javalizi.blog.mapper.LinkMapper;
import com.javalizi.blog.pojo.Link;
import com.javalizi.blog.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 友情链接Service实现类
 * @author Administrator
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Resource
	private LinkMapper linkMapper;


	@Override
	public List<Link> list(Map<String, Object> map) {
		return null;
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
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
