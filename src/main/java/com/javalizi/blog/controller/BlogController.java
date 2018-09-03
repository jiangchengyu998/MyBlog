package com.javalizi.blog.controller;

import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.Blog;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.util.WebResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * ����Controller��
 * @author Administrator
 *
 */
@Api(value = "BlogController",tags = "BlogController")
@RestController
@RequestMapping("/blog")
public class BlogController {

	private static Logger logger = LoggerFactory.getLogger(BlogController.class);

	@Resource
	private BlogService blogService;

	@ApiOperation(value = "��ҳ��ѯ���еĲ���", notes = "��ҳ��ѯ���еĲ���")
	@RequestMapping(method = RequestMethod.GET)
	public WebResponse<PageInfo<Blog>> getAll(Blog blog,
											  @RequestParam(required = false, defaultValue = "1") int start,
											  @RequestParam(required = false, defaultValue = "10") int size){
		try{
			PageInfo<Blog> pageInfo = blogService.selectByPage(blog, start, size);
			return new WebResponse<PageInfo<Blog>>().success(pageInfo);
		}catch (Exception e){
			logger.error(e.getMessage(),e);
			return new WebResponse<PageInfo<Blog>>().failure(e.getMessage());
		}
	}
	
	/**
	 * ���󲩿���ϸ��Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "����id��ѯ����", notes = "����id��ѯ����")
	@RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
	public WebResponse<Blog> details(@PathVariable("id") Integer id){
		Blog blog = null;
		try {
			blog = blogService.findById(id);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new WebResponse<Blog>().failure(e.getMessage());
		}
		return new WebResponse<Blog>().success(blog);
	}
	
}
