package com.javalizi.blog.controller;

import com.javalizi.blog.pojo.Blog;
import com.javalizi.blog.pojo.BlogType;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.service.BlogTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Ö÷Ò³Contrller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class IndexContrller {

	@Resource
	private BlogService blogService;
	@Resource
	private BlogTypeService blogTypeService;
	
	/**
	 * ÇëÇóÖ÷Ò³
	 * @return
	 */
	@RequestMapping("/")
	public String index(@RequestParam(value="page",required=false)String page,
                        @RequestParam(value="typeId",required=false)String typeId,
                        @RequestParam(value="releaseDateStr",required=false)String releaseDateStr,
                        HttpServletRequest request){
		List<Blog> blogList = blogService.countList();
		request.setAttribute("blogList", blogList);
		List<BlogType> blogTypeCountList = blogTypeService.countList();
        request.setAttribute("blogTypeCountList", blogTypeCountList);
        request.setAttribute("mainPage", "blog/list.html");
		return "index";
	}

}
