package com.javalizi.blog.controller;

import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.Blog;
import com.javalizi.blog.pojo.BlogType;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.service.BlogTypeService;
import com.javalizi.blog.service.CommentService;
import com.javalizi.blog.util.StringUtil;
import com.javalizi.blog.util.WebResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����Controller��
 * @author Administrator
 *
 */
//@Api(value = "BlogController",tags = "BlogController")
@Controller
@RequestMapping("/blog")
public class BlogController {

	private static Logger logger = LoggerFactory.getLogger(BlogController.class);

	@Resource
	private BlogService blogService;
	@Resource
	private BlogTypeService blogTypeService;
	@Resource
	private CommentService commentService;

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
	public String details(@PathVariable("id") Integer id, HttpServletRequest request ){
		Blog blog=blogService.findById(id);
		String keyWords=blog.getKeyword();
		if(StringUtil.isNotEmpty(keyWords)){
			String arr[]=keyWords.split(" ");
			request.setAttribute("keywords", StringUtil.filterWhite(Arrays.asList(arr)));
		}else{
			request.setAttribute("keywords",null);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("blogId", blog.getId());
		map.put("state", 1);
		List<BlogType> blogTypeCountList = blogTypeService.countList();
		request.setAttribute("blogTypeCountList", blogTypeCountList);
		request.setAttribute("blog", blog);
		request.setAttribute("commentList", commentService.list(map));
		request.setAttribute("pageCode", this.getUpAndDownPageCode(blogService.getLastBlog(id), blogService.getNextBlog(id), request.getServletContext().getContextPath()));
		request.setAttribute("pageTitle", blog.getTitle()+"java��Դ����ϵͳ");
		request.setAttribute("mainPage", "blog/view.html");
		return "index";
	}

	/**
	 * ��ȡ��һƪ���ͺ���һƪ����
	 * @param lastBlog
	 * @param nextBlog
	 * @param projectContext
	 * @return
	 */
	private String getUpAndDownPageCode(Blog lastBlog,Blog nextBlog,String projectContext){
		StringBuffer pageCode=new StringBuffer();
		if(lastBlog==null || lastBlog.getId()==null){
			pageCode.append("<p>��һƪ��û����</p>");
		}else{
			pageCode.append("<p>��һƪ��<a href='"+projectContext+"/blog/articles/"+lastBlog.getId()+".html'>"+lastBlog.getTitle()+"</a></p>");
		}

		if(nextBlog==null || nextBlog.getId()==null){
			pageCode.append("<p>��һƪ��û����</p>");
		}else{
			pageCode.append("<p>��һƪ��<a href='"+projectContext+"/blog/articles/"+nextBlog.getId()+".html'>"+nextBlog.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}
}
