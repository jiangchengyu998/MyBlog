package com.javalizi.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javalizi.blog.mapper.BlogTypeMapper;
import com.javalizi.blog.pojo.BlogType;
import com.javalizi.blog.pojo.BlogTypeExample;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.service.BlogTypeService;
import net.sf.json.JSONObject;
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
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

	@Resource
	private BlogTypeMapper blogTypeMapper;
	@Resource
	private BlogService blogService;


	/**
	 * @param blogType
	 * @param start
	 * @param size
	 * @return
	 */
	@Override
	public PageInfo<BlogType> selectByPage(BlogType blogType, int start, int size) {
		BlogTypeExample example = new BlogTypeExample();
		BlogTypeExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause("orderNo");
//		if(blog.getTypeid() != null){
//			criteria.andTypeidEqualTo(blog.getTypeid());
//		}
//		if(StringUtil.isNotEmpty(blog.getReleaseDateStr())){
//			example.setReleaseDateStr(blog.getReleaseDateStr());
//		}
		PageHelper.startPage(start, size);
		List<BlogType> blogTypes = blogTypeMapper.selectByExample(example);
		return new PageInfo<>(blogTypes);
	}

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
		return blogTypeMapper.insertSelective(blogType);
	}

	@Override
	public Integer update(BlogType blogType) {
		return blogTypeMapper.updateByPrimaryKeySelective(blogType);
	}

	@Override
	public Integer delete(Integer id) {
		return null;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public Integer delete(String ids, JSONObject result) {
		int i1 = 0;
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			if(blogService.getBlogByTypeId(Integer.parseInt(idsStr[i]))>0){
				result.put("exist", "博客类别下有博客，不能删除！");
			}else{
				i1 = blogTypeMapper.deleteByPrimaryKey(Integer.parseInt(idsStr[i]));
			}
		}

		return i1;
	}
}
