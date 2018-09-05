package com.javalizi.blog.controller;

import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.Blog;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.service.BlogTypeService;
import com.javalizi.blog.service.BloggerService;
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
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 博客
 * @author Administrator
 *
 */
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
    @Resource
    private BloggerService bloggerService;

	@ApiOperation(value = "获取所有blog", notes = "获取所有blog")
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
	 * 根据id获取blog
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据id获取blog", notes = "根据id获取blog")
	@RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
	public ModelAndView details(@PathVariable("id") Integer id, HttpServletRequest request ){
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

        ModelAndView mav=new ModelAndView();
//        Blogger blogger=bloggerService.find(); // 获取博主信息
//        blogger.setPassword(null);
//        mav.addObject("blogger", blogger);

//		List<BlogType> blogTypeCountList = blogTypeService.countList();
//        mav.addObject("blogTypeCountList", blogTypeCountList);
        mav.addObject("blog", blog);
        mav.addObject("commentList", commentService.list(map));
        mav.addObject("pageCode", this.getUpAndDownPageCode(blogService.getLastBlog(id), blogService.getNextBlog(id), request.getServletContext().getContextPath()));
        mav.addObject("pageTitle", blog.getTitle()+"java开源");
        mav.addObject("mainPage", "blog/view.html");
        mav.setViewName("index");
		return mav;
	}

	/**
	 *
	 * @param lastBlog
	 * @param nextBlog
	 * @param projectContext
	 * @return
	 */
	private String getUpAndDownPageCode(Blog lastBlog,Blog nextBlog,String projectContext){
		StringBuffer pageCode=new StringBuffer();
		if(lastBlog==null || lastBlog.getId()==null){
			pageCode.append("<p>没有了</p>");
		}else{
			pageCode.append("<p>下一篇<a href='"+projectContext+"/blog/articles/"+lastBlog.getId()+".html'>"+lastBlog.getTitle()+"</a></p>");
		}

		if(nextBlog==null || nextBlog.getId()==null){
			pageCode.append("<p>没有了</p>");
		}else{
			pageCode.append("<p>上一篇<a href='"+projectContext+"/blog/articles/"+nextBlog.getId()+".html'>"+nextBlog.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}
}
